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

//This class is for the hard part of the forth level of the game
public class Level4H extends Application{
	private boolean animPause=true;
	private boolean disappPause=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Create a pane
		Pane pane=new Pane();

		Text textTime=new Text(20,50,"Time :");// text for time
		textTime.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,30)); //set font type of time
		textTime.setFill(Color.GREY); //color of time text

		Text time = new Text(95,55,"");//text for chronometer
		Integer STARTTIME = 10;//starting second
		IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);// To implement binding, change variable timeSeconds from Integer to IntegerProperty
		time.textProperty().bind(timeSeconds.asString());
		time.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,50));
		time.setFill(Color.PALEVIOLETRED);
		//in this animation if time is up, return the same level
		Timeline animationTime = new Timeline(new KeyFrame(Duration.seconds(STARTTIME+1),e->{
			if(timeSeconds.get()==0 ){
				pane.getChildren().clear();
				Level4H lev4h=new Level4H();
				try {
					lev4h.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		},new KeyValue(timeSeconds, 0)));
		animationTime.play();
		timeSeconds.set(STARTTIME);
		pane.getChildren().addAll(time,textTime);

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

		//Create a circle object with given values
		Circle circleA=new Circle();
		circleA.setCenterX(120);
		circleA.setCenterY(325);
		circleA.setRadius(30);
		//Create a line which is first horizontal light line of the circleA
		Line hLLineA1=new Line(150,325,250,325);
		hLLineA1.setStroke(Color.BLACK);
		hLLineA1.setStrokeWidth(1);
		//Create new circle object for disconnector with given parameters 
		Circle disconnector=new Circle();
		disconnector.setFill(Color.WHITE);
		disconnector.setCenterX(280);
		disconnector.setCenterY(325);
		disconnector.setRadius(30);
		disconnector.setStroke(Color.BLACK);
		disconnector.setStrokeWidth(1);
		//Create a line which is second horizontal light line of the circleA
		Line hLLineA2=new Line(310,325,600,325);
		hLLineA2.setStroke(Color.BLACK);
		hLLineA2.setStrokeWidth(1);
		//Create a line which is vertical light line of the circleA
		Line vLLineA=new Line(600,325,600,310);
		vLLineA.setStroke(Color.BLACK);
		vLLineA.setStrokeWidth(1);	
		//Create a line which is horizontal bold line of the circleA
		Line hBLineA=new Line(590,310,610,310);
		hBLineA.setStroke(Color.BLACK);
		hBLineA.setStrokeWidth(3);
		//Create a line which is vertical bold line of the circleA
		Line vBLineA=new Line(600,310,600,100);
		vBLineA.setStroke(Color.BLACK);
		vBLineA.setStrokeWidth(3);	

		//Create new circle object with given parameters
		Circle circleB=new Circle();
		circleB.setCenterX(280);
		circleB.setCenterY(450);
		circleB.setRadius(30);
		//Create a line which is first vertical light line of the circleB
		Line vLLineB1=new Line(280,420,280,355);
		vLLineB1.setStroke(Color.BLACK);
		vLLineB1.setStrokeWidth(1);
		//Cretae a line which is insside the disconnector
		Line inDisc=new Line(280,355,280,295);
		inDisc.setStroke(Color.BLACK);
		inDisc.setStrokeWidth(1);
		//Create a line which is second vertical light line of the circleB
		Line vLLineB2=new Line(280,295,280,110);
		vLLineB2.setStroke(Color.BLACK);
		vLLineB2.setStrokeWidth(1);
		//Create a line which is horizontal light line of the circleB
		Line hLLineB=new Line(280,110,295,110);
		hLLineB.setStroke(Color.BLACK);
		hLLineB.setStrokeWidth(1);
		//Create a line which is vertical bold line of the circleB
		Line vBLineB=new Line(295,100,295,120);
		vBLineB.setStroke(Color.BLACK);
		vBLineB.setStrokeWidth(3);
		//Create a line which is first horizontal bold line of the circleB
		Line hBLineB1=new Line(295,110,565,110);
		hBLineB1.setStroke(Color.BLACK);
		hBLineB1.setStrokeWidth(3);	
		//Cretae a semicircle by using arc
		Arc semicircleB=new Arc(600,110,35,35,0,180);
		semicircleB.setStrokeWidth(3);
		semicircleB.setType(ArcType.OPEN);
		semicircleB.setFill(Color.WHITE);
		semicircleB.setStroke(Color.BLACK);
		//Create a line which is second horizontal bold line of the circleB
		Line hBLineB2=new Line(635,110,650,110);
		hBLineB2.setStroke(Color.BLACK);
		hBLineB2.setStrokeWidth(3);	

		//when the disconnector is clicked the line inside it(inDisc) will rotate 90 degrees (and it will change the connections between nodes)
		disconnector.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc.getEndY()==vLLineB2.getStartY()){ 
					inDisc.setStartY(hLLineA1.getEndY()); inDisc.setStartX(hLLineA1.getEndX()); 
					inDisc.setEndY(hLLineA2.getStartY()); inDisc.setEndX(hLLineA2.getStartX()); 

				} 
				else {inDisc.setEndY(vLLineB2.getStartY());
				inDisc.setEndX(vLLineB2.getStartX());
				inDisc.setStartY(vLLineB1.getEndY()); inDisc.setStartX(vLLineB1.getEndX());  
				}
			}});

		//when player clicks circle A
		circleA.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc.getStartX()==hLLineA1.getEndX()){//Check if all nodes are connected,that is,if the disconnector is in right direction
					if((hBLineA.getEndX()-hBLineA.getStartX())==20){//prevent from clicking circle more times.
						hBLineA.setStartX(hBLineA.getStartX()-25);//enlarge connection line
						hBLineA.setEndX(hBLineA.getEndX()+25);//enlarge connection line
						//this animation for decreasing the width of them to removeAll from pane 
						Timeline animationThinA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							hBLineA.setStrokeWidth(hBLineA.getStrokeWidth()-0.50);
							vLLineA.setStrokeWidth(vLLineA.getStrokeWidth()-0.20);
							hLLineA1.setStrokeWidth(hLLineA1.getStrokeWidth()-0.20);
							hLLineA2.setStrokeWidth(hLLineA2.getStrokeWidth()-0.20);
							if(hBLineA.getStrokeWidth()==0.50)
								pane.getChildren().removeAll(hBLineA,vLLineA,circleA,hLLineA1,hLLineA2);				
						}));
						animationThinA.setCycleCount(Timeline.INDEFINITE);
						//to move variables through connection line of that circle
						Timeline animationDisappA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(vBLineA.getEndY()!=hBLineA.getEndY())//to move lines and semicircles through connection line
								vBLineA.setEndY(vBLineA.getEndY()+5);
							if(vBLineA.getEndY()==hBLineA.getEndY()){//remove first line when it completes the movement
								pane.getChildren().remove(vBLineA);
								animationThinA.play();
							}
						}));
						animationDisappA.setCycleCount(Timeline.INDEFINITE);
						animationDisappA.play();
					}
				}
			}});

		//when player clicks circle B
		circleB.setOnMouseClicked(e -> {
			if(inDisc.getStartX()==vLLineB1.getEndX()){//Check if all nodes are connected,that is,if the disconnector is in right direction
				if((vBLineB.getEndY()-vBLineB.getStartY())==20){//prevent from clicking circle more times.
					vBLineB.setStartY(vBLineB.getStartY()-25);//enlarge connection line
					vBLineB.setEndY(vBLineB.getEndY()+25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane 
					Timeline animationThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineB.setStrokeWidth(vBLineB.getStrokeWidth()-0.50);
						hLLineB.setStrokeWidth(hLLineB.getStrokeWidth()-0.20);
						vLLineB1.setStrokeWidth(vLLineB1.getStrokeWidth()-0.20);
						vLLineB2.setStrokeWidth(vLLineB2.getStrokeWidth()-0.20);
						inDisc.setStrokeWidth(inDisc.getStrokeWidth()-0.20);
						disconnector.setStrokeWidth(disconnector.getStrokeWidth()-0.20);
						if(vBLineB.getStrokeWidth()==0.50 && timeSeconds.get()!=0){
							animationTime.pause();
							pane.getChildren().removeAll(vBLineB,hLLineB,vLLineB1,vLLineB2,circleB,inDisc,disconnector);	
							Level5H lev5h=new Level5H();
							try {
								lev5h.start(primaryStage);
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
						hLLineB.setStrokeWidth(hLLineB.getStrokeWidth()-0.20);
						vLLineB1.setStrokeWidth(vLLineB1.getStrokeWidth()-0.20);
						vLLineB2.setStrokeWidth(vLLineB2.getStrokeWidth()-0.20);
						inDisc.setStrokeWidth(inDisc.getStrokeWidth()-0.20);
						disconnector.setStrokeWidth(disconnector.getStrokeWidth()-0.20);
						if(vBLineB.getStrokeWidth()==0.50){
							animationTime.pause();
							pane.getChildren().removeAll(vBLineB,hLLineB,vLLineB1,vLLineB2,circleB,inDisc,disconnector);
							pane.getChildren().clear();
							Level4H lev4h=new Level4H();
							try {
								lev4h.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}));
					animationCollThinB.setCycleCount(Timeline.INDEFINITE);
					//this animation is for collision situation
					Timeline animationCollB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(hBLineB2.intersects(vBLineA.getEndX()+4.5,vBLineA.getEndY(), 0, 10)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
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
					animationCollB.play();}
			}});

		//Add the object to the pane
		pane.getChildren().addAll(circleA,hLLineA1,disconnector,hLLineA2,vLLineA,hBLineA,circleB,vLLineB1,inDisc,vLLineB2,hLLineB,vBLineB,hBLineB1,semicircleB,vBLineA,hBLineB2);
		//Create a scene with given parameters and place pane into it
		Scene scene=new Scene(pane,750,500);
		primaryStage.setTitle("Level4H"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
}
