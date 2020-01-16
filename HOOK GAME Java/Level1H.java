/** *
 * Authors are HAVA KARAÇAM 150315029 and KEVSER ÝLDEÞ 150116048. The purpose of this program is displaying  start game scene,and
 * level 1, level 2, level 3,level 4,level 5 scenes.They generally were occured with lines,circles and semicircles.The purpose of the game 
 * is complete the levels without any collision.
 * 
 */
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
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
import javafx.util.Duration;

//This class is for the hard part of the first level of the game
public class Level1H extends Application {
	private boolean animPause=true;
	private boolean disappPause=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();

		Text text2 = new Text(20, 50, "Time :");// text for time
		text2.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, FontPosture.ITALIC, 30));//set font type of time
		text2.setFill(Color.GREY);//color of time text

		Integer STARTTIME = 8;//starting second
		Text time = new Text(95, 55, "");//text for chronometer
		IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);// To implement binding, change variable timeSeconds from Integer to IntegerProperty
		time.textProperty().bind(timeSeconds.asString());
		time.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, FontPosture.ITALIC, 50));
		time.setFill(Color.PALEVIOLETRED);
		//in this animation if time is up, return the same level
		Timeline animationTime = new Timeline(new KeyFrame(Duration.seconds(STARTTIME + 1), e -> {
			if (timeSeconds.get() == 0) {
				pane.getChildren().clear();
				Level1H lev1h = new Level1H();
				try {
					lev1h.start(primaryStage);//call the start method
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}, new KeyValue(timeSeconds, 0)));
		animationTime.play();
		timeSeconds.set(STARTTIME);
		pane.getChildren().addAll(time, text2);//adding all nodes

		//Create a rectangle for level chart
		Rectangle lCrectangle=new Rectangle(20,405,110,80);
		lCrectangle.setArcWidth(15);
		lCrectangle.setArcHeight(25);
		lCrectangle.setFill(Color.DIMGREY);
		//Create a text with the name "LEVEL CHART"
		Text lCREC=new Text(40,420,"\nLEVEL\nCHART");
		lCREC.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,20));
		lCREC.setFill(Color.WHITE);
		//Add them tothe pane
		pane.getChildren().addAll(lCrectangle,lCREC);

		//As this level is hard level when rectangle is clicked it creates a level chart object for hard levels and calls start method of it.
		lCrectangle.setOnMouseClicked(e -> {
			if(disappPause){
				animPause=false;
				animationTime.pause();
				LevelChartH lVh=new LevelChartH();
				try {
					lVh.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		//It does the same thing as above but it runs when text is clicked
		lCREC.setOnMouseClicked(e -> {
			if(disappPause){
				animPause=false;
				animationTime.pause();
				LevelChartH lVh=new LevelChartH();
				try {
					lVh.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// creating circle
		Circle circleA = new Circle();
		circleA.setCenterX(450);
		circleA.setCenterY(440);
		circleA.setRadius(30);
		Line vLLineA = new Line(450, 410, 450, 300);// creating light line
		vLLineA.setStroke(Color.BLACK);
		vLLineA.setStrokeWidth(1);
		Line hBLineA = new Line(440, 300, 460, 300);// creating horizontal bold
		// line
		hBLineA.setStroke(Color.BLACK);
		hBLineA.setStrokeWidth(3);
		Line vBLineA = new Line(450, 300, 450, 80);// creating vertical bold
		// line
		vBLineA.setStroke(Color.BLACK);
		vBLineA.setStrokeWidth(3);
		circleA.setOnMouseClicked(e -> {
			if(disappPause){
				if((hBLineA.getEndX()-hBLineA.getStartX())==20){//prevent from clicking circle more times.
					hBLineA.setStartX(hBLineA.getStartX()-25);//enlarge connection line
					hBLineA.setEndX(hBLineA.getEndX()+25);//enlarge connection line
					//this animation for decrease the width of them to removeAll from pane
					Timeline animationThinA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						hBLineA.setStrokeWidth(hBLineA.getStrokeWidth()-0.50);
						vLLineA.setStrokeWidth(vLLineA.getStrokeWidth()-0.20);
						if(hBLineA.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(hBLineA,vLLineA,circleA);
						}
					}));
					animationThinA.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(vBLineA.getEndY()!=hBLineA.getEndY())//to move line through connection line
							vBLineA.setEndY(vBLineA.getEndY()+5);
						if(vBLineA.getEndY()==hBLineA.getEndY()){//remove line when it completes the movement
							pane.getChildren().remove(vBLineA);
							animationThinA.play();
						}
					}));
					animationDisappA.setCycleCount(Timeline.INDEFINITE);
					animationDisappA.play();
				}
			}});

		//Create new circle object with given parameters
		Circle circleB=new Circle();
		circleB.setCenterX(640);
		circleB.setCenterY(330);
		circleB.setRadius(30);
		//Create a line which is first horizontal light line of the circleB
		Line hLLineB1=new Line(610,330,100,330);
		hLLineB1.setStroke(Color.BLACK);
		hLLineB1.setStrokeWidth(1);
		//Create a line which is vertical light line of the circleB
		Line vLLineB=new Line(100,330,100,90);
		vLLineB.setStroke(Color.BLACK);
		vLLineB.setStrokeWidth(1);
		//Create a line which is second horizontal light line of the circleB
		Line hLLineB2=new Line(100,90,115,90);
		hLLineB2.setStroke(Color.BLACK);
		hLLineB2.setStrokeWidth(1);
		//Create a line which is vertical bold line of the circleB
		Line vBLineB=new Line(115,80,115,100);
		vBLineB.setStroke(Color.BLACK);
		vBLineB.setStrokeWidth(3);
		//Create a line which is first horizontal bold line of the circleB
		Line hBLineB1=new Line(115,90,415,90);
		hBLineB1.setStroke(Color.BLACK);
		hBLineB1.setStrokeWidth(3);
		//Create a semicircle by using arc with given parameters
		Arc semicircleB=new Arc(450,90,35,35,0,180);
		semicircleB.setStrokeWidth(3);
		semicircleB.setType(ArcType.OPEN);
		semicircleB.setFill(Color.WHITE);
		semicircleB.setStroke(Color.BLACK);
		//Create a line which is second horizontal bold line of the circleB
		Line hBLineB2=new Line(485,90,600,90);
		hBLineB2.setStroke(Color.BLACK);
		hBLineB2.setStrokeWidth(3);

		circleB.setOnMouseClicked(e -> {
			if((vBLineB.getEndY()-vBLineB.getStartY())==20){//prevent from clicking circle more times.
				vBLineB.setStartY(vBLineB.getStartY()-25);//enlarge connection line
				vBLineB.setEndY(vBLineB.getEndY()+25);//enlarge connection line
				//this animation for decrease the width of them to removeAll from pane 
				Timeline animationThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
					vBLineB.setStrokeWidth(vBLineB.getStrokeWidth()-0.50);
					hLLineB1.setStrokeWidth(hLLineB1.getStrokeWidth()-0.20);
					hLLineB2.setStrokeWidth(hLLineB2.getStrokeWidth()-0.20);
					vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);

					if(vBLineB.getStrokeWidth()==0.50 && timeSeconds.get()!=0){
						animationTime.pause();
						pane.getChildren().removeAll(time,vBLineB,hLLineB1,hLLineB2,vLLineB,circleB);
						Level2H lev2h=new Level2H();
						try {
							lev2h.start(primaryStage);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}));
				animationThinB.setCycleCount(Timeline.INDEFINITE);

				//to move variables through connection line of that circle
				Timeline animationDisappB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
					if(animPause){
						if(hBLineB1.getEndX()!=vBLineB.getEndX()){//to move lines and semicircles through connection line
							hBLineB1.setEndX(hBLineB1.getEndX()-5);
							semicircleB.setCenterX(semicircleB.getCenterX()-5);
							hBLineB2.setEndX(hBLineB2.getEndX()-5);
							hBLineB2.setStartX(hBLineB2.getStartX()-5);

						}
						if(hBLineB1.getEndX()==vBLineB.getEndX())//remove first line when it completes the movement
							pane.getChildren().remove(hBLineB1);     				
						if(semicircleB.intersects(vBLineB.getStartX(), vBLineB.getStartY(),0, vBLineB.getEndY())){//to move semicircles and remaining lines through connection line
							semicircleB.setCenterX(semicircleB.getCenterX()-5);
							semicircleB.setLength(180-Math.toDegrees(Math.acos((semicircleB.getCenterX()-vBLineB.getEndX())/35.0)));
							hBLineB2.setEndX(hBLineB2.getEndX()-5);
							hBLineB2.setStartX(hBLineB2.getStartX()-5);
						}
						if((semicircleB.getCenterX()+35)==vBLineB.getEndX())//remove semicircle when it completes the movement
							pane.getChildren().remove(semicircleB);

						if(hBLineB2.getStartX()==vBLineB.getEndX())//to move remaining lines through connection line
							hBLineB2.setEndX(hBLineB2.getEndX()-5);
						if(hBLineB2.getEndX()==vBLineB.getEndX()){//remove remaining line when complete it's move
							pane.getChildren().remove(hBLineB2);
							animationThinB.play();
						}
					}

				}));
				animationDisappB.setCycleCount(Timeline.INDEFINITE);
				animationDisappB.play();
				//this animation for collision to decrease the width of them to removeAll from pane 
				Timeline animationCollThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
					vBLineB.setStrokeWidth(vBLineB.getStrokeWidth()-0.50);
					hLLineB1.setStrokeWidth(hLLineB1.getStrokeWidth()-0.20);
					hLLineB2.setStrokeWidth(hLLineB2.getStrokeWidth()-0.20);
					vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);
					if(vBLineB.getStrokeWidth()==0.50){
						animationTime.pause();
						pane.getChildren().removeAll(vBLineB,hLLineB1,hLLineB2,vLLineB,circleB);
						pane.getChildren().clear();
						Level1H lev1h=new Level1H();
						try {
							lev1h.start(primaryStage);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}));
				animationThinB.setCycleCount(Timeline.INDEFINITE);

				//this animation is for collision situation
				Timeline animationCollB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
					if(hBLineB2.intersects(vBLineA.getEndX()+4.5,vBLineA.getEndY(), 0, 10)){
						animationDisappB.pause();
						disappPause=false;
						Text collision=new Text(300,250,"UPPSS!\nCOLLISION");
						collision.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,30));
						collision.setFill(Color.GREY); 
						pane.getChildren().add(collision);
						animationCollThinB.play();

					}
				}));
				animationCollB.setCycleCount(Timeline.INDEFINITE);
				animationCollB.play();
			}});


		// Add the object to the pane
		pane.getChildren().addAll(circleB, circleA, vLLineA, hBLineA, hLLineB1, vLLineB, hLLineB2, vBLineB, hBLineB1,semicircleB, hBLineB2, vBLineA);
		// Create a scene with given parameters and place pane into it
		Scene scene = new Scene(pane, 750, 500);
		primaryStage.setTitle("Level1H");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
