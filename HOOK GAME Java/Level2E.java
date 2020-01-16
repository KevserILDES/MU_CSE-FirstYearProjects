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

public class Level2E extends Application {
	private boolean animPause=true;
	private boolean disappPause=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane=new Pane();//create a pane

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

		Circle circleA=new Circle();//create a circle
		circleA.setCenterX(415);
		circleA.setCenterY(375);
		circleA.setRadius(30);
		Line vLLineA=new Line(415,345,415,280);//create a vertical light line
		vLLineA.setStroke(Color.BLACK);
		vLLineA.setStrokeWidth(1);
		Line hBLineA=new Line(405,280,425,280);//create horizontal bold line
		hBLineA.setStroke(Color.BLACK);
		hBLineA.setStrokeWidth(3);
		Line vBLineA=new Line(415,280,415,190);//create vertical bold line
		vBLineA.setStroke(Color.BLACK);
		vBLineA.setStrokeWidth(3);
		//when player clicks circle A
		circleA.setOnMouseClicked(e -> {
			if(disappPause){
				if((hBLineA.getEndX()-hBLineA.getStartX())==20){ //prevent from clicking circle more times.
					hBLineA.setStartX(hBLineA.getStartX()-25);//enlarge connection line
					hBLineA.setEndX(hBLineA.getEndX()+25);//enlarge connection line
					//this animation for decrease the width of them to removeAll from pane
					Timeline animationThinA=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						hBLineA.setStrokeWidth(hBLineA.getStrokeWidth()-0.50);
						vLLineA.setStrokeWidth(vLLineA.getStrokeWidth()-0.20);
						if(hBLineA.getStrokeWidth()==0.50)
							pane.getChildren().removeAll(hBLineA,vLLineA,circleA);
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

		Circle circleB=new Circle();//create a circle
		circleB.setCenterX(625);
		circleB.setCenterY(375);
		circleB.setRadius(30);
		Line vLLineB=new Line(625,345,625,200);//create vertical light line
		vLLineB.setStroke(Color.BLACK);
		vLLineB.setStrokeWidth(1);
		Line hLLineB=new Line(625,200,610,200);//create horizontal light line
		hLLineB.setStroke(Color.BLACK);
		hLLineB.setStrokeWidth(1);
		Line vBLineB=new Line(610,190,610,210);//create vertical bold line
		vBLineB.setStroke(Color.BLACK);
		vBLineB.setStrokeWidth(3);
		Line hBLineB=new Line(610,200,450,200);//create horizontal bold line
		hBLineB.setStroke(Color.BLACK);
		hBLineB.setStrokeWidth(3);
		Arc semicircleB=new Arc(415,200,35,35,180,-180);//create arc
		semicircleB.setStrokeWidth(3);
		semicircleB.setType(ArcType.OPEN);
		semicircleB.setFill(Color.WHITE);
		semicircleB.setStroke(Color.BLACK);
		Line hBLineB2=new Line(380,200,300,200);//create horizontal bold line
		hBLineB2.setStroke(Color.BLACK);
		hBLineB2.setStrokeWidth(3);
		circleB.setOnMouseClicked(e -> {//when player click circle B
			if(disappPause){
				if((vBLineB.getEndY()-vBLineB.getStartY())==20){//prevent to click circle more times
					vBLineB.setStartY(vBLineB.getStartY()-25);//enlarge connection line
					vBLineB.setEndY(vBLineB.getEndY()+25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane
					Timeline animationThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineB.setStrokeWidth(vBLineB.getStrokeWidth()-0.50);
						hLLineB.setStrokeWidth(hLLineB.getStrokeWidth()-0.20);
						vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);

						if(vBLineB.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(vBLineB,hLLineB,vLLineB,circleB);
						}
					}));
					animationThinB.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(hBLineB.getEndX()!=vBLineB.getEndX()){//to move lines and semicircles through connection line
							hBLineB.setEndX(hBLineB.getEndX()+5);
							semicircleB.setCenterX(semicircleB.getCenterX()+5);
							hBLineB2.setEndX(hBLineB2.getEndX()+5);
							hBLineB2.setStartX(hBLineB2.getStartX()+5);
						}
						if(hBLineB.getEndX()==vBLineB.getEndX())//remove first line when it completes the movement
							pane.getChildren().remove(hBLineB);
						if(semicircleB.intersects(vBLineB.getStartX(), vBLineB.getStartY(),0, vBLineB.getEndY())){//to move semicircles and remaining lines through connection line
							semicircleB.setCenterX(semicircleB.getCenterX()+5);
							semicircleB.setLength(-(180-Math.toDegrees(Math.acos((semicircleB.getCenterX()-vBLineB.getEndX())/-35.0))));
							hBLineB2.setEndX(hBLineB2.getEndX()+5);
							hBLineB2.setStartX(hBLineB2.getStartX()+5);
						}
						if((semicircleB.getCenterX()+35)==vBLineB.getEndX())//remove semicircle when it completes the movement
							pane.getChildren().remove(semicircleB);

						if(hBLineB2.getStartX()==vBLineB.getEndX())//to move remaining lines through connection line
							hBLineB2.setEndX(hBLineB2.getEndX()+5);
						if(hBLineB2.getEndX()==vBLineB.getEndX()){//remove remaining line when complete it's move
							pane.getChildren().remove(hBLineB2);
							animationThinB.play();
						}

					}));
					animationDisappB.setCycleCount(Timeline.INDEFINITE);
					animationDisappB.play();
					//this animation for collision to decrease the width of them to removeAll from pane
					Timeline animationCollThinB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineB.setStrokeWidth(vBLineB.getStrokeWidth()-0.50);
						hLLineB.setStrokeWidth(hLLineB.getStrokeWidth()-0.20);

						vLLineB.setStrokeWidth(vLLineB.getStrokeWidth()-0.20);
						if(vBLineB.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(vBLineB,hLLineB,vLLineB,circleB);
							pane.getChildren().clear();
							Level2E lev2e=new Level2E();
							try {
								lev2e.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}));
					animationThinB.setCycleCount(Timeline.INDEFINITE);
					//this animation is for collision situation
					Timeline animationCollB=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(hBLineB2.intersects(vBLineA.getEndX()-4.5,vBLineA.getEndY(), 0, 10)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
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
		Circle circleC=new Circle();//create circle
		circleC.setCenterX(160);
		circleC.setCenterY(375);
		circleC.setRadius(30);
		Line vLLineC=new Line(160,345,160,85);//create vertical light line
		vLLineC.setStroke(Color.BLACK);
		vLLineC.setStrokeWidth(1);
		Line hLLineC=new Line(160,85,175,85);//create horizontal light line
		hLLineC.setStroke(Color.BLACK);
		hLLineC.setStrokeWidth(1);
		Line vBLineC=new Line(175,95,175,75);//create vertical bold line
		vBLineC.setStroke(Color.BLACK);
		vBLineC.setStrokeWidth(3);
		Line hBLineC=new Line(175,85,320,85);//create horizontal bold line
		hBLineC.setStroke(Color.BLACK);
		hBLineC.setStrokeWidth(3);
		//when player click circle C
		circleC.setOnMouseClicked(e -> {
			if(disappPause){
				if(Math.abs((vBLineC.getEndY()-vBLineC.getStartY()))==20){//prevent to click circle more times
					vBLineC.setStartY(vBLineC.getStartY()+25);//enlarge connection line
					vBLineC.setEndY(vBLineC.getEndY()-25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane
					Timeline animationThinC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						vBLineC.setStrokeWidth(vBLineC.getStrokeWidth()-0.50);
						vLLineC.setStrokeWidth(vLLineC.getStrokeWidth()-0.20);
						hLLineC.setStrokeWidth(hLLineC.getStrokeWidth()-0.20);

						if(vBLineC.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(vBLineC,vLLineC,hLLineC,circleC);
						}
					}));
					animationThinC.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappC=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(hBLineC.getEndX()!=vBLineC.getEndX())//to move lines and semicircles through connection line
							hBLineC.setEndX(hBLineC.getEndX()-5);
						if(hBLineC.getEndX()==vBLineC.getEndX()){//remove first line when it completes the movement
							pane.getChildren().remove(hBLineC);
							animationThinC.play();
						}
					}));
					animationDisappC.setCycleCount(Timeline.INDEFINITE);
					animationDisappC.play();
				}
			}});
		Circle circleD=new Circle();//create circle
		circleD.setCenterX(310);
		circleD.setCenterY(375);
		circleD.setRadius(30);
		Arc semicircleD=new Arc(310,200,35,35,90,180);//create arc for semicircle
		semicircleD.setStrokeWidth(3);
		semicircleD.setType(ArcType.OPEN);
		semicircleD.setFill(Color.WHITE);
		semicircleD.setStroke(Color.BLACK);
		Line vLLineD=new Line(310,345,310,280);//create vertical light line
		vLLineD.setStroke(Color.BLACK);
		vLLineD.setStrokeWidth(1);
		Line hBLineD=new Line(300,280,320,280);//create horizontal bold line
		hBLineD.setStroke(Color.BLACK);
		hBLineD.setStrokeWidth(3);
		Line vBLineD=new Line(310,280,310,235);//create vertical bold line
		vBLineD.setStroke(Color.BLACK);
		vBLineD.setStrokeWidth(3);
		Line vBLineD2=new Line(310,165,310,120);//create vertical bold line
		vBLineD2.setStroke(Color.BLACK);
		vBLineD2.setStrokeWidth(3);
		Arc semicircleD2=new Arc(310,85,35,35,90,-180);//Second arc for second semicircle
		semicircleD2.setStrokeWidth(3);
		semicircleD2.setType(ArcType.OPEN);
		semicircleD2.setFill(Color.WHITE);
		semicircleD2.setStroke(Color.BLACK);
		Line vBLineD3=new Line(310,50,310,30);//create vertical bold line
		vBLineD3.setStroke(Color.BLACK);
		vBLineD3.setStrokeWidth(3);

		//when player click circle D
		circleD.setOnMouseClicked(e -> {
			if(disappPause){
				if((hBLineD.getEndX()-hBLineD.getStartX())==20){//prevent to click circle more times
					hBLineD.setStartX(hBLineD.getStartX()-25);//enlarge connection line
					hBLineD.setEndX(hBLineD.getEndX()+25);//enlarge connection line
					//this animation for decreasing the width of them to removeAll from pane 
					Timeline animationThinD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						hBLineD.setStrokeWidth(hBLineD.getStrokeWidth()-0.50);
						vLLineD.setStrokeWidth(vLLineD.getStrokeWidth()-0.20);
						if(hBLineD.getStrokeWidth()==0.50){
							pane.getChildren().removeAll(hBLineD,vLLineD,circleD);
							Level3E lev3e=new Level3E();
							try {
								lev3e.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}));
					animationThinD.setCycleCount(Timeline.INDEFINITE);
					//to move variables through connection line of that circle
					Timeline animationDisappD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(animPause){
							if(vBLineD.getEndY()!=hBLineD.getEndY()){//to move lines and semicircles through connection line
								vBLineD.setEndY(vBLineD.getEndY()+5);
								semicircleD.setCenterY(semicircleD.getCenterY()+5);
								semicircleD2.setCenterY(semicircleD2.getCenterY()+5);
								vBLineD2.setEndY(vBLineD2.getEndY()+5);
								vBLineD2.setStartY(vBLineD2.getStartY()+5);
								vBLineD3.setEndY(vBLineD3.getEndY()+5);
								vBLineD3.setStartY(vBLineD3.getStartY()+5);
							}
							if(vBLineD.getEndY()==hBLineD.getEndY()){//remove first line when it completes the movement
								pane.getChildren().remove(vBLineD);
							}
							if(semicircleD.intersects(hBLineD.getStartX(), hBLineD.getStartY(),hBLineD.getEndX(), 0)){//to move semicircles and remaining lines through connection line
								semicircleD.setCenterY(semicircleD.getCenterY()+5);
								semicircleD.setLength(180-Math.toDegrees(Math.acos((semicircleD.getCenterY()-hBLineD.getEndY())/-35.0)));
								vBLineD2.setEndY(vBLineD2.getEndY()+5);
								vBLineD2.setStartY(vBLineD2.getStartY()+5);
								semicircleD2.setCenterY(semicircleD2.getCenterY()+5);
								vBLineD3.setEndY(vBLineD3.getEndY()+5);
								vBLineD3.setStartY(vBLineD3.getStartY()+5);
							}
							if((semicircleD.getCenterY()-35)==hBLineD.getEndY()){//remove semicircle when it completes the movement
								pane.getChildren().remove(semicircleD);
							}
							if(vBLineD2.getStartY()==hBLineD.getEndY()){//to move remaining lines through connection line
								vBLineD2.setEndY(vBLineD2.getEndY()+5);
								semicircleD2.setCenterY(semicircleD2.getCenterY()+5);
								vBLineD3.setEndY(vBLineD3.getEndY()+5);
								vBLineD3.setStartY(vBLineD3.getStartY()+5);
							}
							if(vBLineD2.getEndY()==hBLineD.getEndY()){//remove remaining line when complete it's move
								pane.getChildren().remove(vBLineD2);
								vBLineD2.setEndX(0);
								vBLineD2.setStartX(0);
								vBLineD2.setEndY(0);
								vBLineD2.setStartY(0);
							}
							if(semicircleD2.intersects(hBLineD.getStartX(), hBLineD.getStartY(),hBLineD.getEndX(), 0)){//to move semicircles and remaining lines through connection line
								semicircleD2.setCenterY(semicircleD2.getCenterY()+5);
								semicircleD2.setLength(-(180-Math.toDegrees(Math.acos((semicircleD2.getCenterY()-hBLineD.getEndY())/-35.0))));
								vBLineD3.setEndY(vBLineD3.getEndY()+5);
								vBLineD3.setStartY(vBLineD3.getStartY()+5);
							}
							if((semicircleD2.getCenterY()-35)==hBLineD.getEndY())//remove semicircle when it completes the movement
								pane.getChildren().remove(semicircleD2);
							if(vBLineD3.getStartY()==hBLineD.getEndY())//to move remaining lines through connection line
								vBLineD3.setEndY(vBLineD3.getEndY()+5);

							if(vBLineD3.getEndY()==hBLineD.getEndY()){//remove remaining line when complete it's move
								pane.getChildren().remove(vBLineD3);
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
						if(hBLineD.getStrokeWidth()==0.50){
							//	pane.getChildren().removeAll(hBLineD,vLLineD,circleD);
							pane.getChildren().clear();
							Level2E lev2e=new Level2E();
							try {
								lev2e.start(primaryStage);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}));
					animationCollThinD.setCycleCount(Timeline.INDEFINITE);
					//this animation is for collision situation
					Timeline animationCollD=new Timeline(new KeyFrame(Duration.millis(50),el -> {
						if(vBLineD2.intersects(hBLineB2.getEndX(),hBLineB2.getEndY()-4.5, 10, 0) || vBLineD3.intersects(hBLineC.getEndX()-9,hBLineC.getEndY()-4.5, 10, 0)){//if semicircle intersects line game will pause and upps message appear on screen then starts same level again
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

			}});

		//Add all nodes to the pane
		pane.getChildren().addAll(semicircleD,circleB,vLLineB,hLLineB,vBLineB,hBLineB,semicircleB,hBLineB2,circleA,vLLineA,hBLineA,vBLineA);
		pane.getChildren().addAll(circleC,vLLineC,hLLineC,vBLineC);
		pane.getChildren().addAll(circleD,vLLineD,hBLineD,vBLineD,vBLineD2,semicircleD2,vBLineD3,hBLineC);
		//Create a scene with given parameters and place pane into it
		Scene scene=new Scene(pane,750,500);
		primaryStage.setTitle("Level2E");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
