package com.example.javaafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor Tool");
		primaryStage.show();
	}

	private MenuBar createMenu() {

		// File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked");
			// More code....
		});


		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		// Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		// TODO
		Alert alertdialog = new Alert(Alert.AlertType.INFORMATION);
		alertdialog.setTitle("My first app");
		alertdialog.setHeaderText("learning javaFX");
		alertdialog.setContentText("i am beginner of this course");
		ButtonType yesbtn = new ButtonType("Yes");
		ButtonType nobtn = new ButtonType("No");
		alertdialog.getButtonTypes().setAll(yesbtn, nobtn);
		Optional<ButtonType> clickedbtn = alertdialog.showAndWait();
		if (clickedbtn.isPresent() && clickedbtn.get() == yesbtn){
			System.out.println("Yes button Clicked");
		}else {
			System.out.println("No Button Clicked");
		}

	}

	@Override
	public void stop() throws Exception {

		System.out.println("stop");
		super.stop();
	}
}
