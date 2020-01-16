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

public class Level3E extends Application {
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


		Circle circleA = new Circle();//creating circle
		circleA.setCenterX(250);
		circleA.setCenterY(375);
		circleA.setRadius(30);
		Line hLLineA = new Line(280, 375, 435, 375);//creating horizontal light line
		hLLineA.setStroke(Color.BLACK);
		hLLineA.setStrokeWidth(1);
		Line vLLineA = new Line(435, 375, 435, 180);//creating vertical light line
		vLLineA.setStroke(Color.BLACK);
		vLLineA.setStrokeWidth(1);
		Line hLLineA2 = new Line(435, 180, 450, 180);//creating horizontal light line
		hLLineA2.setStroke(Color.BLACK);
		hLLineA2.setStrokeWidth(1);
		Line vBLineA = new Line(450, 170, 450, 190);//creating vertical bold line
		vBLineA.setStroke(Color.BLACK);
		vBLineA.setStrokeWidth(3);
		Line hBLineA = new Line(450, 180, 595, 180);//creating horizontal bold line
		hBLineA.setStroke(Color.BLACK);
		hBLineA.setStrokeWidth(3);

		//when player clicks circle A
		circleA.setOnMouseClicked(e -> {
			if(disappPause){
				if(Math.abs((vBLineA.getEndY()-vBLineA.getStartY()))==20){//prevent from clicking circle more times.
					vBLineA.setStartY(vBLineA.getStartY()-25);//enlarge connection line
					vBLineA.setEndY(vBLineA.getEndY()+25);//enlarge connection line
					//this animation for decrease the width of them to removeAll from pane
					Timeline animationThinA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineA.setStrokeWidth(vBLineA.getStrokeWidth()-0.50);
						vLLineA.setStrokeWidth(vLLineA.getStrokeWidth()-0.20);		
						hLLineA.setStrokeWidth(hLLineA.getStrokeWidth()-0.20);
						hLLineA2.setStrokeWidth(hLLineA2.getStrokeWidth()-0.20);

						if(vBLineA.getStrokeWidth()==0.50)
							pane.getChildren().removeAll(vBLineA,vLLineA,hLLineA,circleA,hLLineA2);
					}));
					animationThinA.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(hBLineA.getEndX()!=vBLineA.getEndX())//to move line through connection line
							hBLineA.setEndX(hBLineA.getEndX()-5);
						if(hBLineA.getEndX()==vBLineA.getEndX()){//remove line when it completes the movement
							pane.getChildren().remove(hBLineA);
							animationThinA.play();
						}
					}));
					animationDisappA.setCycleCount(Timeline.INDEFINITE);
					animationDisappA.play();
				}
			}});

		Circle circleB = new Circle();//creating a circle
		circleB.setCenterX(150);
		circleB.setCenterY(300);
		circleB.setRadius(30);
		Line hLLineB = new Line(180, 300, 585, 300);//creating horizontal light line
		hLLineB.setStroke(Color.BLACK);
		hLLineB.setStrokeWidth(1);
		Line vLLineB = new Line(585, 300, 585, 285);//creating vertical light line
		vLLineB.setStroke(Color.BLACK);
		vLLineB.setStrokeWidth(1);
		Line hBLineB = new Line(575, 285, 595, 285);//creating horizontal bold line
		hBLineB.setStroke(Color.BLACK);
		hBLineB.setStrokeWidth(3);
		Line vBLineB = new Line(585, 285, 585, 215);//creating vertical bold line
		vBLineB.setStroke(Color.BLACK);
		vBLineB.setStrokeWidth(3);
		Arc semicircleB=new Arc(585,180,35,35,90,-180);//creating arc for semicircle
		semicircleB.setStrokeWidth(3);
		semicircleB.setType(ArcType.OPEN);
		semicircleB.setFill(Color.WHITE);
		semicircleB.setStroke(Color.BLACK);
		Line vBLineB2 = new Line(585, 145, 585, 75);//creating vertical bold line
		vBLineB2.setStroke(Color.BLACK);
		vBLineB2.setStrokeWidth(3);

		circleB.setOnMouseClicked(e -> {//when player click circle B
			if(disappPause){
				if((hBLineB.getEndX()-hBLineB.getStartX())==20){//prevent to click circle more times
					hBLineB.setStartX(hBLineB.getStartX()-25);//enlarge connection line
					hBLineB.setEndX(hBLineB.getEndX()+25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane
					Timeline animationThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						hBLineB.setStrokeWidth(hBLineB.getStrokeWidth()-0.50);
						vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);
						hLLineB.setStrokeWidth(hLLineB.getStrokeWidth()-0.20);

						if(hBLineB.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(hBLineB,vLLineB,circleB,hLLineB);

						}

					}));
					animationThinB.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(vBLineB.getEndY()!=hBLineB.getEndY()){//to move lines and semicircles through connection line
							vBLineB.setEndY(vBLineB.getEndY()+5);
							semicircleB.setCenterY(semicircleB.getCenterY()+5);
							vBLineB2.setEndY(vBLineB2.getEndY()+5);
							vBLineB2.setStartY(vBLineB2.getStartY()+5);
						}
						if(vBLineB.getEndY()==hBLineB.getEndY()){//remove first line when it completes the movement
							pane.getChildren().remove(vBLineB);
						}

						if(semicircleB.intersects(hBLineB.getStartX(), hBLineB.getStartY(),hBLineB.getEndX(), 0)){//to move semicircles and remaining lines through connection line
							semicircleB.setCenterY(semicircleB.getCenterY()+5);
							semicircleB.setLength(-(180-Math.toDegrees(Math.acos((semicircleB.getCenterY()-hBLineB.getEndY())/-35.0))));
							vBLineB2.setEndY(vBLineB2.getEndY()+5);
							vBLineB2.setStartY(vBLineB2.getStartY()+5);
						}
						if((semicircleB.getCenterY()-35)==hBLineB.getEndY())//remove semicircle when it completes the movement
							pane.getChildren().remove(semicircleB);
						if(vBLineB2.getStartY()==hBLineB.getEndY()){//to move remaining lines through connection line
							vBLineB2.setEndY(vBLineB2.getEndY()+5);

						}
						if(vBLineB2.getEndY()==hBLineB.getEndY()){//remove remaining line when complete it's move
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
						hLLineB.setStrokeWidth(hLLineB.getStrokeWidth()-0.20);

						if(hBLineB.getStrokeWidth()==0.50){
							//pane.getChildren().removeAll(hBLineB,vLLineB,circleB);
							pane.getChildren().clear();
							Level3E lev3e=new Level3E();
							try {
								lev3e.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}));

					Timeline animationCollB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(vBLineB2.intersects(hBLineA.getEndX()-9,hBLineA.getEndY()-4.5, 10, 0)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
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
			}});


		Circle circleC = new Circle();//creating circle
		circleC.setCenterX(350);
		circleC.setCenterY(450);
		circleC.setRadius(30);
		Line vLLineC = new Line(350, 420, 350, 85);//creating vertical light line
		vLLineC.setStroke(Color.BLACK);
		vLLineC.setStrokeWidth(1);
		Line hLLineC = new Line(350, 85, 365, 85);//creating horizontal light line
		hLLineC.setStroke(Color.BLACK);
		hLLineC.setStrokeWidth(1);
		Line vBLineC = new Line(365, 75, 365, 95);//creating vertical bold line
		vBLineC.setStroke(Color.BLACK);
		vBLineC.setStrokeWidth(3);
		Line hBLineC = new Line(365, 85, 550, 85);//creating horizontal bold line
		hBLineC.setStroke(Color.BLACK);
		hBLineC.setStrokeWidth(3);
		Arc semicircleC = new Arc(585, 85, 35, 35, 0, 180);//creating arc
		semicircleC.setStrokeWidth(3);
		semicircleC.setType(ArcType.OPEN);
		semicircleC.setFill(Color.WHITE);
		semicircleC.setStroke(Color.BLACK);
		Line hBLineC2 = new Line(620, 85, 680, 85);//creating horizontal bold line
		hBLineC2.setStroke(Color.BLACK);
		hBLineC2.setStrokeWidth(3);

		circleC.setOnMouseClicked(e -> {//when player click circle C
			if(disappPause){
				if((vBLineC.getEndY()-vBLineC.getStartY())==20){//prevent to click circle more times
					vBLineC.setStartY(vBLineC.getStartY()-25);//enlarge connection line
					vBLineC.setEndY(vBLineC.getEndY()+25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane
					Timeline animationThinC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineC.setStrokeWidth(vBLineC.getStrokeWidth()-0.50);
						hLLineC.setStrokeWidth(hLLineC.getStrokeWidth()-0.20);
						vLLineC.setStrokeWidth(vLLineC.getStrokeWidth()-0.20);
						if(vBLineC.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(vBLineC,hLLineC,vLLineC,circleC);	
							Level4E lev4e=new Level4E();
							try {
								lev4e.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}));
					animationThinC.setCycleCount(Timeline.INDEFINITE);

					//to move variables through connection line of that circle
					Timeline animationDisappC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(animPause){
							if(hBLineC.getEndX()!=vBLineC.getEndX()){//to move lines and semicircles through connection line
								hBLineC.setEndX(hBLineC.getEndX()-5);
								semicircleC.setCenterX(semicircleC.getCenterX()-5);
								hBLineC2.setEndX(hBLineC2.getEndX()-5);
								hBLineC2.setStartX(hBLineC2.getStartX()-5);
							}
							if(hBLineC.getEndX()==vBLineC.getEndX())//remove first line when it completes the movement
								pane.getChildren().remove(hBLineC);
							if(semicircleC.intersects(vBLineC.getStartX(), vBLineC.getStartY(),0, vBLineC.getEndY())){//to move semicircles and remaining lines through connection line
								semicircleC.setCenterX(semicircleC.getCenterX()-5);
								semicircleC.setLength(180-Math.toDegrees(Math.acos((semicircleC.getCenterX()-vBLineC.getEndX())/35.0)));
								hBLineC2.setEndX(hBLineC2.getEndX()-5);
								hBLineC2.setStartX(hBLineC2.getStartX()-5);
							}
							if((semicircleC.getCenterX()+35)==vBLineC.getEndX())//remove semicircle when it completes the movement
								pane.getChildren().remove(semicircleC);

							if(hBLineC2.getStartX()==vBLineC.getEndX())//to move remaining lines through connection line
								hBLineC2.setEndX(hBLineC2.getEndX()-5);
							if(hBLineC2.getEndX()==vBLineC.getEndX()){//remove remaining line when complete it's move
								pane.getChildren().remove(hBLineC2);
								animationThinC.play();
							}
						}

					}));
					animationDisappC.setCycleCount(Timeline.INDEFINITE);
					animationDisappC.play();
					//this animation for collision to decrease the width of them to removeAll from pane
					Timeline animationCollThinC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineC.setStrokeWidth(vBLineC.getStrokeWidth()-0.50);
						hLLineC.setStrokeWidth(hLLineC.getStrokeWidth()-0.20);
						vLLineC.setStrokeWidth(vLLineC.getStrokeWidth()-0.20);
						if(vBLineC.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(vBLineC,hLLineC,vLLineC,circleC);
							pane.getChildren().clear();
							Level3E lev3e=new Level3E();
							try {
								lev3e.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}));
					animationCollThinC.setCycleCount(Timeline.INDEFINITE);
					//this animation is for collision situation
					Timeline animationColl=new Timeline(new KeyFrame(Duration.millis(50),el -> {
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
					animationColl.setCycleCount(Timeline.INDEFINITE);
					animationColl.play();
				}
			}});



		//Add all nodes to the pane
		pane.getChildren().addAll(circleC, vLLineC, hLLineC, vBLineC, hBLineC, semicircleC, hBLineC2,circleA,circleB,hLLineB,vLLineB,hBLineB,vBLineB,semicircleB,vBLineB2);
		pane.getChildren().addAll(hLLineA,vLLineA,hLLineA2,vBLineA,hBLineA);
		//Create a scene with given parameters and place pane into it
		Scene scene = new Scene(pane, 750, 500);
		primaryStage.setTitle("Level3E");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}