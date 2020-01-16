/** *
 * Authors are HAVA KARAÇAM 150315029 and KEVSER ÝLDEÞ 150116048. The purpose of this program is displaying  start game scene,and
 * level 1, level 2, level 3,level 4,level 5 scenes.They generally were occured with lines,circles and semicircles.The purpose of the game 
 * is complete the levels without any collision.
 * 
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//This class is level chart of easy levels
public class LevelChartE extends Application{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Create a grid pane (As we have 6 class for easy levels including main screen play using grid pane is easier and more useful)
		GridPane gPane=new GridPane();

		//Create a rectangle for play screen
		Rectangle playrec=new Rectangle(500,350,248,248);
		playrec.setArcWidth(15);
		playrec.setArcHeight(25);
		playrec.setFill(Color.CRIMSON);
		playrec.setStroke(Color.BLACK);
		playrec.setStrokeWidth(2);
		//Add it to first row and first column of pane
		gPane.add(playrec,0,0);

		//Create a text with the PLAY word
		Text pREC=new Text("\t  PLAY");
		pREC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		pREC.setFill(Color.WHITE);
		//Add it to first row and first column of pane (it will be shown right in the middle of the play rectangle)
		gPane.add(pREC, 0, 0);

		//When it is clicked it creates an object of play class and calls its start method
		playrec.setOnMouseClicked(e -> {
			Play play=new Play();
			try {
				play.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		//It does the same thing as above but it is attached to the text 
		pREC.setOnMouseClicked(e -> {
			Play play=new Play();
			try {
				play.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	

		});

		//Create a rectangle for Level1
		Rectangle lev1rec=new Rectangle(500,350,248,248);
		lev1rec.setArcWidth(15);
		lev1rec.setArcHeight(25);
		lev1rec.setFill(Color.MEDIUMVIOLETRED);
		lev1rec.setStroke(Color.BLACK);
		lev1rec.setStrokeWidth(2);
		//Add it to first row and second column of pane
		gPane.add(lev1rec,1,0);

		//Create a text with the LEVEL1 word
		Text l1REC=new Text("\t  LEVEL1");
		l1REC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		l1REC.setFill(Color.WHITE);
		//Add it to first row and second column of pane (it will be shown right in the middle of the level1 rectangle)
		gPane.add(l1REC, 1,0);

		//When it is clicked it creates an object of level1 class and calls its start method
		lev1rec.setOnMouseClicked(e -> {
			Level1E lev1e=new Level1E();
			try {
				lev1e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//It does the same thing as above but it is attached to the text 
		l1REC.setOnMouseClicked(e -> {
			Level1E lev1e=new Level1E();
			try {
				lev1e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		});

		//Create a rectangle for Level2
		Rectangle lev2rec=new Rectangle(500,350,248,248);
		lev2rec.setArcWidth(15);
		lev2rec.setArcHeight(25);
		lev2rec.setFill(Color.ORANGE);
		lev2rec.setStroke(Color.BLACK);
		lev2rec.setStrokeWidth(2);
		//Add it to first row and third column of pane
		gPane.add(lev2rec,2,0);

		//Create a text with the LEVEL2 word
		Text l2REC=new Text("\t  LEVEL2");
		l2REC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		l2REC.setFill(Color.WHITE);
		//Add it to first row and third column of pane (it will be shown right in the middle of the level2 rectangle)
		gPane.add(l2REC, 2,0);

		//When it is clicked it creates an object of level2 class and calls its start method
		lev2rec.setOnMouseClicked(e -> {
			Level2E lev2e=new Level2E();
			try {
				lev2e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//It does the same thing as above but it is attached to the text 
		l2REC.setOnMouseClicked(e -> {
			Level2E lev2e=new Level2E();
			try {
				lev2e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});		

		//Create a rectangle for Level3
		Rectangle lev3rec=new Rectangle(500,350,248,248);
		lev3rec.setArcWidth(15);
		lev3rec.setArcHeight(25);
		lev3rec.setFill(Color.INDIANRED);
		lev3rec.setStroke(Color.BLACK);
		lev3rec.setStrokeWidth(2);
		//Add it to second row and first column of pane
		gPane.add(lev3rec,0,1);

		//Create a text with the LEVEL3 word
		Text l3REC=new Text("\t  LEVEL3");
		l3REC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		l3REC.setFill(Color.WHITE);
		//Add it to second row and first column of pane (it will be shown right in the middle of the level3 rectangle)
		gPane.add(l3REC, 0,1);

		//When it is clicked it creates an object of level3 class and calls its start method
		lev3rec.setOnMouseClicked(e -> {
			Level3E lev3e=new Level3E();
			try {
				lev3e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//It does the same thing as above but it is attached to the text 
		l3REC.setOnMouseClicked(e -> {
			Level3E lev3e=new Level3E();
			try {
				lev3e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//Create a rectangle for Level4
		Rectangle lev4rec=new Rectangle(500,350,248,248);
		lev4rec.setArcWidth(15);
		lev4rec.setArcHeight(25);
		lev4rec.setFill(Color.DARKCYAN);
		lev4rec.setStroke(Color.BLACK);
		lev4rec.setStrokeWidth(2);
		//Add it to second row and second column of pane
		gPane.add(lev4rec,1,1);

		//Create a text with the LEVEL4 word
		Text l4REC=new Text("\t  LEVEL4");
		l4REC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		l4REC.setFill(Color.WHITE);
		//Add it to second row and second column of pane (it will be shown right in the middle of the level4 rectangle)
		gPane.add(l4REC, 1,1);

		//When it is clicked it creates an object of level4 class and calls its start method
		lev4rec.setOnMouseClicked(e -> {
			Level4E lev4e=new Level4E();
			try {
				lev4e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//It does the same thing as above but it is attached to the text 
		l4REC.setOnMouseClicked(e -> {
			Level4E lev4e=new Level4E();
			try {
				lev4e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//Create a rectangle for Level5
		Rectangle lev5rec=new Rectangle(500,350,248,248);
		lev5rec.setArcWidth(15);
		lev5rec.setArcHeight(25);
		lev5rec.setFill(Color.DARKMAGENTA);
		lev5rec.setStroke(Color.BLACK);
		lev5rec.setStrokeWidth(2);
		//Add it to second row and third column of pane
		gPane.add(lev5rec,2,1);

		//Create a text with the LEVEL5 word
		Text l5REC=new Text("\t  LEVEL5");
		l5REC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		l5REC.setFill(Color.WHITE);
		//Add it to second row and third column of pane (it will be shown right in the middle of the level5 rectangle)
		gPane.add(l5REC, 2,1);

		//When it is clicked it creates an object of level5 class and calls its start method
		lev5rec.setOnMouseClicked(e -> {
			Level5E lev5e=new Level5E();
			try {
				lev5e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//It does the same thing as above but it is attached to the text 
		l5REC.setOnMouseClicked(e -> {
			Level5E lev5e=new Level5E();
			try {
				lev5e.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});


		Scene scene=new Scene(gPane,750,500);
		//Set title as LEVEL CHART
		primaryStage.setTitle("LEVEL CHART (E)"); 
		primaryStage.setScene(scene); 
		primaryStage.show();



	}

}
