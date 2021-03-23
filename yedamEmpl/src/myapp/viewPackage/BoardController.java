package myapp.viewPackage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import common.BoardVO;
import common.InputBoardVO;
import common.InputDAO;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class BoardController implements Initializable {
	@FXML
	TableView<BoardVO> tableView;
	@FXML
	TextField boardNo, title;
	@FXML
	TextArea contents;
	@FXML
	ComboBox<String> publicity;
	@FXML
	DatePicker exitDate;
	@FXML
	Button updateBtn, deleteBtn, addBtn;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		deleteBtn.setOnAction(e -> deleteBtnAction(e));
		addBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				addBtnAction(e);
			}

		});

		ObservableList<BoardVO> list = InputDAO.boardList();
		tableView.setPrefWidth(620);

		// 게시번호 출력하기
		TableColumn<BoardVO, Integer> tcBoardNo = (TableColumn<BoardVO, Integer>) tableView.getColumns().get(0);
		tcBoardNo.setCellValueFactory(new PropertyValueFactory<BoardVO, Integer>("boardNo"));

		// 타이틀 내용 출력하기
		TableColumn<BoardVO, String> txTitle = (TableColumn<BoardVO, String>) tableView.getColumns().get(1);
		txTitle.setCellValueFactory(new Callback<CellDataFeatures<BoardVO, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<BoardVO, String> param) {
				return param.getValue().titleProperty();
			}
		});

		// public 컬럼내용 출력하기
		TableColumn<BoardVO, String> tcPub = new TableColumn<BoardVO, String>("공개");
		tcPub.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("publicity"));
		tableView.getColumns().add(tcPub);
		tcPub.setPrefWidth(100);

		TableColumn<BoardVO, String> tcExirDate = new TableColumn<BoardVO, String>("날짜");
		tcExirDate.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("exitDate"));
		tableView.getColumns().add(tcExirDate);
		tcExirDate.setPrefWidth(100);

		TableColumn<BoardVO, String> tcContnets = new TableColumn<BoardVO, String>("내용");
		tcContnets.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("contents"));
		tableView.getColumns().add(tcContnets);
		tcContnets.setPrefWidth(200);

		tableView.setItems(list);

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BoardVO>() {
			@Override
			public void changed(ObservableValue<? extends BoardVO> arg0, BoardVO oldValue, BoardVO newValue) {
				// System.out.println(newValue.getBoardNo());

				if (newValue != null) {
					boardNo.setText(String.valueOf(newValue.getBoardNo()));
					title.setText(newValue.getTitle());
					publicity.setValue(newValue.getPublicity());
					contents.setText(newValue.getContents());
					exitDate.setValue(LocalDate.parse(newValue.getExitDate()));
				}
			}
		});
	} // end of initialize

	public void updateBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));
		vo.setContents(contents.getText());
		vo.setExitDate(exitDate.getValue().toString());
		vo.setPublicity(publicity.getValue());
		InputDAO.updateBoard(vo);

		tableView.setItems(InputDAO.boardList()); // 수정 후 수정된 화면을 보여줌
	}

	public void deleteBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));

		InputDAO.deleteBoard(vo);
		tableView.setItems(InputDAO.boardList());

	}

	public void addBtnAction(ActionEvent e) {
		// 팝업창 열기
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);

		try {
			AnchorPane ap = FXMLLoader.load(getClass().getResource("BoardAdd.fxml"));
			Scene scene = new Scene(ap);
			stage.setScene(scene);
			stage.show();

			Button btnReg = (Button) ap.lookup("#btnReg");
			btnReg.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					TextField txtTitle = (TextField) ap.lookup("#txtTitle");
					PasswordField txtPassword = (PasswordField) ap.lookup("#txtPassword");
					ComboBox comboPublic = (ComboBox) ap.lookup("#comboPublic");
					DatePicker dateExit = (DatePicker) ap.lookup("#dateExit");
					TextArea txtContent = (TextArea) ap.lookup("#txtContent");

					InputBoardVO vo = new InputBoardVO();
					vo.setTitle(txtTitle.getText());
					vo.setPasswd(txtPassword.getText());
					vo.setPublicity(comboPublic.getValue().toString());
					vo.setExitDate(dateExit.getValue().toString());
					vo.setContnets(txtContent.getText());

					InputDAO.insertBoard(vo);
					// System.out.println(txtTitle.getText());

					tableView.setItems(InputDAO.boardList());
					stage.close();
				}
			});

			Button btnCancel = (Button) ap.lookup("#btnCancel");
			btnCancel.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					stage.close();
				}
			});

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	} // end of addBtnAction

	
	
	public void preBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));
			
		InputDAO.preSelectBoard(vo);
		
		tableView.setItems(InputDAO.boardList());
		

	} //end of preBtnAction

	public void nextBtnAction(ActionEvent e) {

	} //end of nextBtnAction

}
