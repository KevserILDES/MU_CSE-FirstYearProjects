/** *
 * Authors are HAVA KARAÇAM 150315029 and KEVSER ÝLDEÞ 150116048. The purpose of this program is displaying  start game scene,and
 * level 1, level 2, level 3,level 4,level 5 scenes.They generally were occured with lines,circles and semicircles.The purpose of the game 
 * is complete the levels without any collision.
 * 
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

//This class is for the fifth level of the game
public class Level5E extends Application{
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

		//As this level is easy level when rectangle is clicked it creates a level chart object for easy levels and calls start method of it.
		lCrectangle.setOnMouseClicked(e -> {
			if(disappPause){
				animPause=false;
				LevelChartE lVe=new LevelChartE();
				try {
					lVe.start(primaryStage);
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
				LevelChartE lVe=new LevelChartE();
				try {
					lVe.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});


		//Create new Circle object with given values
		Circle circle=new Circle();
		circle.setFill(Color.CRIMSON);
		circle.setStroke(Color.BLACK);
		circle.setCenterX(375);
		circle.setCenterY(400);
		circle.setRadius(75);	

		//Create a text with the word PLAY AGAIN and this will be shown in the middle of the circle
		Text text1=new Text(325,383,"  PLAY\nAGAIN");
		text1.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,30));
		text1.setFill(Color.WHITE);

		//Whencircle is clicked turn back to the main scene wich is Play 
		circle.setOnMouseClicked(e -> {
			Play play=new Play();
			try {
				play.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}); 

		//It does the same thing as above but it runs when text is clicked because the text PLAY is in the midlle of the circle
		text1.setOnMouseClicked(e -> {Play play=new Play(); try {
			play.start(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		});

		//Create an image for the background image and put it in imageview
		Image image = new Image("hqdefault.jpg");
		ImageView iv1 = new ImageView();
		iv1.setFitWidth(750);
		iv1.setFitHeight(500);
		iv1.setImage(image);

		//Create a circle object
		Circle circleA=new Circle();
		circleA.setCenterX(600);
		circleA.setCenterY(440);
		circleA.setRadius(30);
		//Create a line which is vertical light line of the circleA
		Line vLLineA=new Line(600,410,600,150);
		vLLineA.setStroke(Color.BLACK);
		vLLineA.setStrokeWidth(1);
		//Create a line which is horizontal light line of the circleA
		Line hLLineA=new Line(600,150,585,150);
		hLLineA.setStroke(Color.BLACK);
		hLLineA.setStrokeWidth(1);
		//Create a line which is vertical bold line of the circleA
		Line vBLineA=new Line(585,140,585,160);
		vBLineA.setStroke(Color.BLACK);
		vBLineA.setStrokeWidth(3);
		//Create a line which is horizontal bold line of the circleA
		Line hBLineA=new Line(585,150,510,150);
		hBLineA.setStroke(Color.BLACK);
		hBLineA.setStrokeWidth(3);

		//Crate a new circle object
		Circle circleB=new Circle();
		circleB.setCenterX(100);
		circleB.setCenterY(260);
		circleB.setRadius(30);
		//Create a line which is first horizontal light line of the circleB
		Line hLLineB1=new Line(130,260,210,260);
		hLLineB1.setStroke(Color.BLACK);
		hLLineB1.setStrokeWidth(1);	
		//Create a circle for the first disconnector1
		Circle disconnector1=new Circle();
		disconnector1.setFill(Color.WHITE);
		disconnector1.setCenterX(240);
		disconnector1.setCenterY(260);
		disconnector1.setRadius(30);
		disconnector1.setStroke(Color.BLACK);
		disconnector1.setStrokeWidth(1);
		//Create a line which is second horizontal light line of the circleB
		Line hLLineB2=new Line(270,260,520,260);
		hLLineB2.setStroke(Color.BLACK);
		hLLineB2.setStrokeWidth(1);	
		//Create a line which is vertical light line of the circleB
		Line vLLineB=new Line(520,260,520,245);
		vLLineB.setStroke(Color.BLACK);
		vLLineB.setStrokeWidth(1);
		//Create a line which is horizontal bold line of the circleB
		Line hBLineB=new Line(510,245,530,245);
		hBLineB.setStroke(Color.BLACK);
		hBLineB.setStrokeWidth(3);
		//Create a line which is first vertical bold line of the circleB
		Line vBLineB1=new Line(520,245,520,185);
		vBLineB1.setStroke(Color.BLACK);
		vBLineB1.setStrokeWidth(3);
		//Create a semicircle by using arc
		Arc semicircleB=new Arc(520,150,35,35,90,180);
		semicircleB.setStrokeWidth(3);
		semicircleB.setType(ArcType.OPEN);
		semicircleB.setFill(Color.WHITE);
		semicircleB.setStroke(Color.BLACK);
		//Create a line which is second vertical bold line of the circleB
		Line vBLineB2=new Line(520,115,520,90);
		vBLineB2.setStroke(Color.BLACK);
		vBLineB2.setStrokeWidth(3);

		//Cretae a new circle object
		Circle circleC=new Circle();
		circleC.setCenterX(240);
		circleC.setCenterY(440);
		circleC.setRadius(30);
		//Create a line which is first vertical light line of the circleC
		Line vLLineC1=new Line(240,410,240,380);
		vLLineC1.setStroke(Color.BLACK);
		vLLineC1.setStrokeWidth(1);
		//Create a circle for the second disconnector
		Circle disconnector2=new Circle();
		disconnector2.setFill(Color.WHITE);
		disconnector2.setCenterX(240);
		disconnector2.setCenterY(350);
		disconnector2.setRadius(30);
		disconnector2.setStroke(Color.BLACK);
		disconnector2.setStrokeWidth(1);
		//Create a line which is second vertical light line of the circleC
		Line vLLineC2=new Line(240,320,240,290);
		vLLineC2.setStroke(Color.BLACK);
		vLLineC2.setStrokeWidth(1);
		//Create a line which is inside the disconnector
		Line inDisc1=new Line(240,290,240,230);
		inDisc1.setStrokeWidth(1);
		inDisc1.setStroke(Color.BLACK);
		//Create a line which is third vertical light line of the circleC
		Line vLLineC3=new Line(240,230,240,95);
		vLLineC3.setStroke(Color.BLACK);
		vLLineC3.setStrokeWidth(1);
		//Create a line which is horizontal light line of the circleC
		Line hLLineC=new Line(240,95,255,95);
		hLLineC.setStroke(Color.BLACK);
		hLLineC.setStrokeWidth(1);	
		//Create a line which is vertical bold line of the circleC
		Line vBLineC=new Line(255,85,255,105);
		vBLineC.setStroke(Color.BLACK);
		vBLineC.setStrokeWidth(3);
		//Create a line which is first horizontal bold line of the circleC
		Line hBLineC1=new Line(255,95,485,95);
		hBLineC1.setStroke(Color.BLACK);
		hBLineC1.setStrokeWidth(3);
		//Create a semicircle by using arc
		Arc semicircleC=new Arc(520,95,35,35,0,180);
		semicircleC.setStrokeWidth(3);
		semicircleC.setType(ArcType.OPEN);
		semicircleC.setFill(Color.WHITE);
		semicircleC.setStroke(Color.BLACK);
		//Create a line which is second horizontal bold line of the circleC
		Line hBLineC2=new Line(555,95,655,95);
		hBLineC2.setStroke(Color.BLACK);
		hBLineC2.setStrokeWidth(3);

		//Cretae a new circle object
		Circle circleD=new Circle();
		circleD.setCenterX(100);
		circleD.setCenterY(350);
		circleD.setRadius(30);
		//Create a line which is first horizontal light line of the circleD
		Line hLLineD1=new Line(130,350,210,350);
		hLLineD1.setStroke(Color.BLACK);
		hLLineD1.setStrokeWidth(1);
		//Create a line which is inside the disconnector
		Line inDisc2=new Line(210,350,270,350);
		inDisc2.setStrokeWidth(1);
		inDisc2.setStroke(Color.BLACK);
		//Create a line which is second horizontal light line of the circleD
		Line hLLineD2=new Line(270,350,645,350);
		hLLineD2.setStroke(Color.BLACK);
		hLLineD2.setStrokeWidth(1);	
		//Create a line which is vertical light line of the circleD
		Line vLLineD=new Line(645,350,645,335);
		vLLineD.setStroke(Color.BLACK);
		vLLineD.setStrokeWidth(1);
		//Create a line which is horizontal bold line of the circleD
		Line hBLineD=new Line(635,335,655,335);
		hBLineD.setStroke(Color.BLACK);
		hBLineD.setStrokeWidth(3);
		//Create a line which is first vertical bold line of the circleD
		Line vBLineD1=new Line(645,335,645,130);
		vBLineD1.setStroke(Color.BLACK);
		vBLineD1.setStrokeWidth(3);
		//Create a semicircle by using arc
		Arc semicircleD=new Arc(645,95,35,35,90,-180);
		semicircleD.setStrokeWidth(3);
		semicircleD.setType(ArcType.OPEN);
		semicircleD.setFill(Color.WHITE);
		semicircleD.setStroke(Color.BLACK);
		//Create a line which is second vertical bold line of the circleD
		Line vBLineD2=new Line(645,60,645,35);
		vBLineD2.setStroke(Color.BLACK);
		vBLineD2.setStrokeWidth(3);

		//when the disconnector is clicked the line inside it(inDisc) will rotate 90 degrees (and it will change the connections between nodes)
		disconnector1.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc1.getStartY()==vLLineC2.getEndY()){ 
					inDisc1.setStartY(hLLineB1.getEndY()); inDisc1.setStartX(hLLineB1.getEndX()); 
					inDisc1.setEndY(hLLineB2.getStartY()); inDisc1.setEndX(hLLineB2.getStartX()); 

				} 
				else {inDisc1.setEndY(vLLineC3.getStartY());
				inDisc1.setEndX(vLLineC3.getStartX());
				inDisc1.setStartY(vLLineC2.getEndY()); inDisc1.setStartX(vLLineC2.getEndX()); 
				}
			}});

		//when the disconnector is clicked the line inside it(inDisc) will rotate 90 degrees (and it will change the connections between nodes)
		disconnector2.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc2.getStartX()==hLLineD1.getEndX()){ 
					inDisc2.setStartY(vLLineC1.getEndY()); inDisc2.setStartX(vLLineC1.getEndX()); 
					inDisc2.setEndY(vLLineC2.getStartY()); inDisc2.setEndX(vLLineC2.getStartX()); 

				} 
				else {inDisc2.setEndY(hLLineD2.getStartY());
				inDisc2.setEndX(hLLineD2.getStartX());
				inDisc2.setStartY(hLLineD1.getEndY()); inDisc2.setStartX(hLLineD1.getEndX()); 
				}
			}});

		//when player clicks circle A
		circleA.setOnMouseClicked(e -> {
			if(disappPause){
				if((vBLineA.getEndY()-vBLineA.getStartY())==20){//prevent from clicking circle more times.
					vBLineA.setStartY(vBLineA.getStartY()-25);//enlarge connection line
					vBLineA.setEndY(vBLineA.getEndY()+25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane 
					Timeline animationThinA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineA.setStrokeWidth(vBLineA.getStrokeWidth()-0.50);
						hLLineA.setStrokeWidth(hLLineA.getStrokeWidth()-0.20);
						vLLineA.setStrokeWidth(vLLineA.getStrokeWidth()-0.20);
						if(vBLineA.getStrokeWidth()==0.50)
							pane.getChildren().removeAll(vBLineA,hLLineA,vLLineA,circleA);
					}));
					animationThinA.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappA=new Timeline(new KeyFrame(Duration.millis(50),el -> {      
						if(hBLineA.getEndX()!=vBLineA.getEndX()){//to move line through connection line
							hBLineA.setEndX(hBLineA.getEndX()+5);
						}
						if(hBLineA.getEndX()==vBLineA.getEndX()){//remove line when it completes the movement
							pane.getChildren().remove(hBLineA);
							animationThinA.play();
						}
					}));
					animationDisappA.setCycleCount(Timeline.INDEFINITE);
					animationDisappA.play();
				}
			}});

		//when player clicks circle B
		circleB.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc1.getStartY()==hLLineB1.getEndY()){//Check if all nodes are connected,that is,if the disconnector is in right direction
					if((hBLineB.getEndX()-hBLineB.getStartX())==20){//prevent from clicking circle more times.
						hBLineB.setStartX(hBLineB.getStartX()-25);//enlarge connection line
						hBLineB.setEndX(hBLineB.getEndX()+25);//enlarge connection line
						//this animation for decreasing the width of them to removeAll from pane 
						Timeline animationThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							hBLineB.setStrokeWidth(hBLineB.getStrokeWidth()-0.50);
							vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);
							hLLineB1.setStrokeWidth(hLLineB1.getStrokeWidth()-0.20);
							hLLineB2.setStrokeWidth(hLLineB2.getStrokeWidth()-0.20);
							if(hBLineB.getStrokeWidth()==0.50){
								pane.getChildren().removeAll(hBLineB,vLLineB,circleB,hLLineB2,hLLineB1);
							}
						}));
						animationThinB.setCycleCount(Timeline.INDEFINITE);
						//to move variables through connection line of that circle
						Timeline animationDisappB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(vBLineB1.getEndY()!=hBLineB.getEndY()){//to move lines and semicircles through connection line
								vBLineB1.setEndY(vBLineB1.getEndY()+5);
								semicircleB.setCenterY(semicircleB.getCenterY()+5);
								vBLineB2.setEndY(vBLineB2.getEndY()+5);
								vBLineB2.setStartY(vBLineB2.getStartY()+5);
							}
							if(vBLineB1.getEndY()==hBLineB.getEndY()){//remove first line when it completes the movement
								pane.getChildren().remove(vBLineB1);
							}
							if(semicircleB.intersects(hBLineB.getStartX(), hBLineB.getStartY(),hBLineB.getEndX(), 0)){//to move semicircles and remaining lines through connection line
								semicircleB.setCenterY(semicircleB.getCenterY()+5);
								semicircleB.setLength(180-Math.toDegrees(Math.acos((semicircleB.getCenterY()-hBLineB.getEndY())/-35.0)));
								vBLineB2.setEndY(vBLineB2.getEndY()+5);
								vBLineB2.setStartY(vBLineB2.getStartY()+5);
							}
							if((semicircleB.getCenterY()-35)==hBLineB.getEndY()){//remove semicircle when it completes the movement
								pane.getChildren().remove(semicircleB);
							}
							if(vBLineB2.getStartY()==hBLineB.getEndY())//to move remaining lines through connection line
								vBLineB2.setEndY(vBLineB2.getEndY()+5);
							if(vBLineB2.getEndY()==hBLineB.getEndY()){//remove remaining line when it completes the movement
								pane.getChildren().remove(vBLineB2);
								animationThinB.play();
							}
						}));
						animationDisappB.setCycleCount(Timeline.INDEFINITE);
						animationDisappB.play();
						//this animation for collision to decrease the width of them to removeAll from pane 
						Timeline animationCollThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							hBLineB.setStrokeWidth(hBLineB.getStrokeWidth()-0.50);
							vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);
							hLLineB1.setStrokeWidth(hLLineB1.getStrokeWidth()-0.20);
							hLLineB2.setStrokeWidth(hLLineB2.getStrokeWidth()-0.20);
							inDisc1.setStrokeWidth(inDisc1.getStrokeWidth()-0.20);
							disconnector1.setStrokeWidth(disconnector1.getStrokeWidth()-0.20);
							if(hBLineB.getStrokeWidth()==0.50){
								pane.getChildren().clear();
								Level5E lev5e=new Level5E();
								try {
									lev5e.start(primaryStage);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}));
						animationThinB.setCycleCount(Timeline.INDEFINITE);
						//this animation is for collision situation
						Timeline animationCollB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(vBLineB2.intersects(hBLineA.getEndX(),hBLineA.getEndY()-4.5, 10, 0)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
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
					}
				}
			}});

		//when player clicks circle C
		circleC.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc2.getStartY()==vLLineC1.getEndY()&&inDisc1.getStartY()==vLLineC2.getEndY()){//Check if all nodes are connected,that is,if the disconnectors are in right direction
					if((vBLineC.getEndY()-vBLineC.getStartY())==20){//prevent from clicking circle more times.
						vBLineC.setStartY(vBLineC.getStartY()-25);//enlarge connection line
						vBLineC.setEndY(vBLineC.getEndY()+25);//enlarge connection line
						//this animation for decreasing the width of them to removeAll from pane 
						Timeline animationThinC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							vBLineC.setStrokeWidth(vBLineC.getStrokeWidth()-0.50);
							hLLineC.setStrokeWidth(hLLineC.getStrokeWidth()-0.20);
							vLLineC1.setStrokeWidth(vLLineC1.getStrokeWidth()-0.20);
							vLLineC2.setStrokeWidth(vLLineC2.getStrokeWidth()-0.20);
							vLLineC3.setStrokeWidth(vLLineC3.getStrokeWidth()-0.20);
							inDisc1.setStrokeWidth(inDisc1.getStrokeWidth()-0.20);
							disconnector1.setStrokeWidth(disconnector1.getStrokeWidth()-0.20);
							if(vBLineC.getStrokeWidth()==0.50){
								pane.getChildren().removeAll(vBLineC,hLLineC,vLLineC1,vLLineC2,vLLineC3, circleC,inDisc1,disconnector1);	
							}
						}));
						animationThinC.setCycleCount(Timeline.INDEFINITE);
						//to move variables through connection line of that circle
						Timeline animationDisappC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(hBLineC1.getEndX()!=vBLineC.getEndX()){//to move lines and semicircles through connection line
								hBLineC1.setEndX(hBLineC1.getEndX()-5);
								semicircleC.setCenterX(semicircleC.getCenterX()-5);
								hBLineC2.setEndX(hBLineC2.getEndX()-5);
								hBLineC2.setStartX(hBLineC2.getStartX()-5);
							}
							if(hBLineC1.getEndX()==vBLineC.getEndX())//remove first line when it completes the movement
								pane.getChildren().remove(hBLineC1);     				
							if(semicircleC.intersects(vBLineC.getStartX(), vBLineC.getStartY(),0, vBLineC.getEndY())){//to move semicircles and remaining lines through connection line
								semicircleC.setCenterX(semicircleC.getCenterX()-5);
								semicircleC.setLength(180-Math.toDegrees(Math.acos((semicircleC.getCenterX()-vBLineC.getEndX())/35.0)));
								hBLineC2.setEndX(hBLineC2.getEndX()-5);
								hBLineC2.setStartX(hBLineC2.getStartX()-5);
							}
							if((semicircleC.getCenterX()+35)==vBLineC.getEndX())//remove semicircle when it completes the movement
								pane.getChildren().remove(semicircleC);
							if(hBLineC2.getStartX()==vBLineC.getEndX())//to move remaining line through connection line
								hBLineC2.setEndX(hBLineC2.getEndX()-5);
							if(hBLineC2.getEndX()==vBLineC.getEndX()){//remove remaining line when it completes the movement
								pane.getChildren().remove(hBLineC2);
								animationThinC.play();
							}
						}));
						animationDisappC.setCycleCount(Timeline.INDEFINITE);
						animationDisappC.play();
						//this animation for collision to decrease the width of them to removeAll from pane 
						Timeline animationCollThinC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							vBLineC.setStrokeWidth(vBLineC.getStrokeWidth()-0.50);
							hLLineC.setStrokeWidth(hLLineC.getStrokeWidth()-0.20);
							vLLineC1.setStrokeWidth(vLLineC1.getStrokeWidth()-0.20);
							vLLineC2.setStrokeWidth(vLLineC2.getStrokeWidth()-0.20);
							vLLineC3.setStrokeWidth(vLLineC3.getStrokeWidth()-0.20);
							inDisc1.setStrokeWidth(inDisc1.getStrokeWidth()-0.20);
							disconnector1.setStrokeWidth(disconnector1.getStrokeWidth()-0.20);
							inDisc2.setStrokeWidth(inDisc2.getStrokeWidth()-0.20);
							disconnector2.setStrokeWidth(disconnector2.getStrokeWidth()-0.20);
							if(vBLineC.getStrokeWidth()==0.50){
								pane.getChildren().removeAll(vBLineC,hLLineC,vLLineC1,vLLineC2,vLLineC2,circleC,inDisc1,disconnector1,inDisc2,disconnector2);
								pane.getChildren().clear();
								Level5E lev5e=new Level5E();
								try {
									lev5e.start(primaryStage);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}));
						animationThinC.setCycleCount(Timeline.INDEFINITE);
						//this animation is for collision situation
						Timeline animationCollC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(hBLineC2.intersects(vBLineB2.getEndX()+4.5,vBLineB2.getEndY(), 0, 10)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
								animationDisappC.pause();
								disappPause=false;
								Text collision=new Text(300,250,"UPPSS!\nCOLLISION");
								collision.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,30));
								collision.setFill(Color.GREY); 
								pane.getChildren().add(collision);
								animationCollThinC.play();
							}
						}));
						animationCollC.setCycleCount(Timeline.INDEFINITE);
						animationCollC.play();
					}
				}
			}});

		//when player clicks circle D
		circleD.setOnMouseClicked(e -> {
			if(disappPause){
				if(inDisc2.getStartX()==hLLineD1.getEndX()){//Check if all nodes are connected,that is,if the disconnector is in right direction
					if((hBLineD.getEndX()-hBLineD.getStartX())==20){//prevent from clicking circle more times.
						hBLineD.setStartX(hBLineD.getStartX()-25);//enlarge connection line
						hBLineD.setEndX(hBLineD.getEndX()+25);//enlarge connection line
						//this animation for decreasing the width of them to removeAll from pane 
						Timeline animationThinD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							hBLineD.setStrokeWidth(hBLineD.getStrokeWidth()-0.50);
							vLLineD.setStrokeWidth(vLLineD.getStrokeWidth()-0.20);
							hLLineD1.setStrokeWidth(hLLineD1.getStrokeWidth()-0.20);
							hLLineD2.setStrokeWidth(hLLineD2.getStrokeWidth()-0.20);
							inDisc2.setStrokeWidth(inDisc2.getStrokeWidth()-0.20);
							disconnector2.setStrokeWidth(disconnector2.getStrokeWidth()-0.20);
							if(hBLineD.getStrokeWidth()==0.50){
								pane.getChildren().removeAll(hBLineD,vLLineD,circleD,hLLineD1,hLLineD2,inDisc2,disconnector2);
								//When all levels are completed add imageview circle and text to pane and settitle as "Win"
								pane.getChildren().addAll(iv1,circle,text1);
								primaryStage.setTitle("Win");	     				
							}
						}));
						animationThinD.setCycleCount(Timeline.INDEFINITE);
						//to move variables through connection line of that circle
						Timeline animationDisappD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(animPause){
								if(vBLineD1.getEndY()!=hBLineD.getEndY()){//to move lines and semicircles through connection line
									vBLineD1.setEndY(vBLineD1.getEndY()+5);
									semicircleD.setCenterY(semicircleD.getCenterY()+5);
									vBLineD2.setEndY(vBLineD2.getEndY()+5);
									vBLineD2.setStartY(vBLineD2.getStartY()+5);
								}
								if(vBLineD1.getEndY()==hBLineD.getEndY()){//remove first line when it completes the movement
									pane.getChildren().remove(vBLineD1);
								}
								if(semicircleD.intersects(hBLineD.getStartX(), hBLineD.getStartY(),hBLineD.getEndX(), 0)){//to move semicircles and remaining lines through connection line
									semicircleD.setCenterY(semicircleD.getCenterY()+5);
									semicircleD.setLength(-(180-Math.toDegrees(Math.acos((semicircleD.getCenterY()-hBLineD.getEndY())/-35.0))));
									vBLineD2.setEndY(vBLineD2.getEndY()+5);
									vBLineD2.setStartY(vBLineD2.getStartY()+5);
								}
								if((semicircleD.getCenterY()-35)==hBLineD.getEndY())//remove semicircle when it completes the movement
									pane.getChildren().remove(semicircleD);
								if(vBLineD2.getStartY()==hBLineD.getEndY()){//to move remaining lines through connection line
									vBLineD2.setEndY(vBLineD2.getEndY()+5);
								}
								if(vBLineD2.getEndY()==hBLineD.getEndY()){//remove remaining line when it completes the movement
									pane.getChildren().remove(vBLineD2);
									animationThinD.play();
								}
							}
						}));
						animationDisappD.setCycleCount(Timeline.INDEFINITE);
						animationDisappD.play();
						//this animation for collision to decrease the width of them to removeAll from pane 
						Timeline animationCollThinD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							hBLineD.setStrokeWidth(hBLineD.getStrokeWidth()-0.50);
							vLLineD.setStrokeWidth(vLLineD.getStrokeWidth()-0.20);
							hLLineD1.setStrokeWidth(hLLineD1.getStrokeWidth()-0.20);
							hLLineD2.setStrokeWidth(hLLineD2.getStrokeWidth()-0.20);
							inDisc2.setStrokeWidth(inDisc2.getStrokeWidth()-0.20);
							disconnector2.setStrokeWidth(disconnector2.getStrokeWidth()-0.20);
							if(hBLineD.getStrokeWidth()==0.50){
								pane.getChildren().clear();
								Level5E lev5e=new Level5E();
								try {
									lev5e.start(primaryStage);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}));
						//this animation is for collision situation
						Timeline animationCollD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
							if(vBLineD2.intersects(hBLineC2.getEndX()-9,hBLineC2.getEndY()-4.5, 10, 0)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
								animationDisappD.pause();
								disappPause=false;
								Text collision=new Text(300,250,"UPPSS!\nCOLLISION");
								collision.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,FontPosture.ITALIC,30));
								collision.setFill(Color.GREY);
								pane.getChildren().add(collision);
								animationCollThinD.play();
							}
						}));
						animationCollD.setCycleCount(Timeline.INDEFINITE);
						animationCollD.play();
					}
				}
			}});

		//Add the object to the pane
		pane.getChildren().addAll(circleA,vLLineA,hLLineA,vBLineA,circleB,hLLineB1,disconnector1,hLLineB2,vLLineB,hBLineB,vBLineB1,semicircleB,hBLineA,circleC,vLLineC1,disconnector2,vLLineC2,inDisc1,vLLineC3,hLLineC,vBLineC,hBLineC1,semicircleC,vBLineB2,circleD,hLLineD1,inDisc2,hLLineD2,vLLineD,hBLineD,vBLineD1,semicircleD,vBLineD2,hBLineC2);
		//Create a scene with given parameters and place pane into it
		Scene scene=new Scene(pane,750,500);
		primaryStage.setTitle("Level5E"); 
		primaryStage.setScene(scene); 
		primaryStage.show();

	}

}
