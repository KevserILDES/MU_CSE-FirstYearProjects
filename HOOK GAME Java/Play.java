/** *
 * Authors are KEVSER İLDEŞ 150116048 and HAVA KARAÇAM 150315029. The purpose of this program is displaying  start game scene,and
 * level 1, level 2, level 3,level 4,level 5 scenes.They generally were occured with lines,circles and semicircles.The purpose of the game 
 * is to complete the levels without any collision.
 * 
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//This class is for the entry scene of the game
public class Play extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Create a pane
		Pane pane=new Pane();

		//Create an image for the background image and put it in imageview
		Image image = new Image("maxresdefault.jpg");
		ImageView iv1 = new ImageView();
		iv1.setFitWidth(750);
		iv1.setFitHeight(500);
		iv1.setImage(image);

		//Create a rectangle object with given values
		Rectangle rectangle=new Rectangle(500,350,200,130);
		rectangle.setArcWidth(15);
		rectangle.setArcHeight(25);
		rectangle.setFill(Color.GREY);
		//Create a text with the word HOW TO PLAY and this will be shown in the middle of the rectangle
		Text textREC=new Text(510,420,"HOW TO PLAY");
		textREC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,25));
		textREC.setFill(Color.WHITE);

		//Create new Circle object with given values
		Circle circle=new Circle();
		circle.setFill(Color.CRIMSON);
		circle.setStroke(Color.BLACK);
		circle.setCenterX(100);
		circle.setCenterY(360);
		circle.setRadius(75);	
		//Create a text with the word PLAY and this will be shown in the middle of the circle
		Text textPlay=new Text(48,368,"PLAY");
		textPlay.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,40));
		textPlay.setFill(Color.WHITE);
		//Create a line which is vertical and light with given values
		Line vLLine=new Line(100,285,100,110);
		vLLine.setStrokeWidth(1.5);
		vLLine.setStroke(Color.BLACK);
		//Create a line which is horizontal and light with given values
		Line hLLine=new Line(100,110,200,110);
		hLLine.setStrokeWidth(1.5);
		hLLine.setStroke(Color.BLACK);
		//Create a line which is vertical and bold with given values
		Line vBLine=new Line(200,95,200,125);
		vBLine.setStrokeWidth(4.5);
		vBLine.setStroke(Color.BLACK);
		//Create a line which is horizontal and bold with given values
		Line hBLine=new Line(200,110,260,110);
		hBLine.setStrokeWidth(4.5);
		hBLine.setStroke(Color.BLACK);
		//Create a semicircle by using arc with given values
		Arc semicircle1=new Arc(305,110,45,45,0,180);
		semicircle1.setStrokeWidth(4.5);
		semicircle1.setType(ArcType.OPEN);
		semicircle1.setFill(Color.POWDERBLUE);
		semicircle1.setStroke(Color.BLACK);
		//Create a line which is between two semicircles with given values
		Line betweenSCs=new Line(350,110,390,110);
		betweenSCs.setStrokeWidth(4.5);
		betweenSCs.setStroke(Color.BLACK);
		//Create another semicircle by using arc with given values
		Arc semicircle2=new Arc(435,110,45,45,180,180);
		semicircle2.setStrokeWidth(4.5);
		semicircle2.setType(ArcType.OPEN);
		semicircle2.setFill(Color.PEACHPUFF);
		semicircle2.setStroke(Color.BLACK);
		//Create a line which is horizontal,bold and connected to the disconnector 
		Line hBDLine=new Line(480,110,520,110);
		hBDLine.setStrokeWidth(4.5);
		hBDLine.setStroke(Color.BLACK);
		//Create a circle object for disconnector with given values
		Circle disconnector=new Circle();
		disconnector.setFill(Color.AZURE);
		disconnector.setCenterX(570);
		disconnector.setCenterY(110);
		disconnector.setRadius(50);
		disconnector.setStroke(Color.BLACK);
		disconnector.setStrokeWidth(3);
		//Create a line which is inside the disconnector
		Line inDisc=new Line(523,110,605,78);
		inDisc.setStrokeWidth(3.2);
		inDisc.setStroke(Color.CRIMSON);
		//Create new text with the word EASY to be first choice for disconnector
		Text textEasy=new Text(626,72,"Easy");
		textEasy.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,30));
		textEasy.setFill(Color.GREY); 
		//Cretae new text with the word HARD to be second choice for disconnector
		Text textHard=new Text(624,152,"Hard");
		textHard.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,30));
		textHard.setFill(Color.GREY); 

		//When the disconnector is clicked change the option for the game(If the end index of the line inside disconnector shows Easy(78) set new end indexes to show Hard and vice versa 
		disconnector.setOnMouseClicked(e -> {
			if(inDisc.getEndY()==78){
				inDisc.setEndY(140);
				inDisc.setEndX(608);
			} 
			else{
				inDisc.setEndY(78); 
				inDisc.setEndX(605);
			}
		});
		//Whencircle is clicked open specific Level according to option that are chosen using disconnector (Easy or Hard) 
		circle.setOnMouseClicked(e -> { 
			if(inDisc.getEndY()==78){
				pane.getChildren().clear();
				Level1E level1=new Level1E();
				try {
					level1.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				pane.getChildren().clear(); 
				Level1H level1h=new Level1H();
				try {
					level1h.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}     		
			}
		}); 

		//It does the same thing as above but it runs when text is clicked because the text PLAY is in the midlle of the circle
		textPlay.setOnMouseClicked(e -> {
			if(inDisc.getEndY()==78){
				pane.getChildren().clear();
				Level1E level1=new Level1E();
				try {
					level1.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			else{
				pane.getChildren().clear(); 
				Level1H level1h=new Level1H(); 
				try {
					level1h.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}     		
			}
		});

		//When rectangle is clicked it creates new pane that contains a rectangle and a textinside it that describes how to play game and finally it adds pane into new scene
		rectangle.setOnMouseClicked(e -> {
			Pane paneHowToPlay=new Pane();

			Text howToPlayMessage=new Text(35,40,"\nIn this game, there are \n lines connected to\n filled-circles. "
					+ "When a \nfilled-circle is clicked on, \nthen the shape connected \n"
					+ "to it starts to slide towards\n to the filled-circle.\n"
					+ "You should complete \nlevels without collision!");
			howToPlayMessage.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,25));
			howToPlayMessage.setFill(Color.WHITE);

			Rectangle rectangleHTP=new Rectangle(20,20,300,310);
			rectangleHTP.setArcWidth(15);
			rectangleHTP.setArcHeight(25);
			rectangleHTP.setFill(Color.GREY);
			paneHowToPlay.getChildren().addAll(rectangleHTP,howToPlayMessage);

			Scene sceneHowToPlay=new Scene(paneHowToPlay,350,350);
			Stage stageForHowToPlay=new Stage();
			stageForHowToPlay.setTitle("HOW TO PLAY");
			stageForHowToPlay.setScene(sceneHowToPlay);
			stageForHowToPlay.show();
		});

		//It does the same thing as above but it runs when textREC is clicked because the text HOW TO PLAY is in the midlle of the rectangle
		textREC.setOnMouseClicked(e -> {
			Pane paneHowToPlay=new Pane();
			Text howToPlayMessage=new Text(35,40,"\nIn this game, there are \n lines connected to\n filled-circles. "
					+ "When a \nfilled-circle is clicked on, \nthen the shape connected \n"
					+ "to it starts to slide towards\n to the filled-circle.\n"
					+ "You should complete \nlevels without collision!");
			howToPlayMessage.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,25));
			howToPlayMessage.setFill(Color.WHITE);

			Rectangle rectangleHTP=new Rectangle(20,20,300,310);
			rectangleHTP.setArcWidth(15);
			rectangleHTP.setArcHeight(25);
			rectangleHTP.setFill(Color.GREY);
			paneHowToPlay.getChildren().addAll(rectangleHTP,howToPlayMessage);

			Scene sceneHowToPlay=new Scene(paneHowToPlay,350,350);
			Stage stageForHowToPlay=new Stage();
			stageForHowToPlay.setTitle("HOW TO PLAY");
			stageForHowToPlay.setScene(sceneHowToPlay);
			stageForHowToPlay.show();
		});

		//Add the object to the pane
		pane.getChildren().addAll(iv1,rectangle,textREC,circle,textPlay,vLLine,hLLine,vBLine,hBLine,semicircle1,betweenSCs,semicircle2,hBDLine,disconnector,inDisc,textEasy,textHard);
		//Create a scene with given parameters and place pane into it
		Scene scene=new Scene(pane,750,500);
		//scene.set
		//Set title as HOOK
		primaryStage.setTitle("HOOK"); 
		primaryStage.setScene(scene); 
		primaryStage.show();

	}

}
