

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class ChessBoard extends Application{
    public static void main(String [] args){
        launch(args);
    }


    @Override
    public void start(Stage stage){
        //instantiate a grid
        GridPane grid=new GridPane();
        grid.setMinSize(320,320);
        boolean colorWhite=false;// will be used to flip the color of the square

        //fill in the grid with rectangles
        for(int i=0; i<8; i++){
            colorWhite=!colorWhite;
            for(int j=0; j<8; j++){
                if(colorWhite){
                    Rectangle white= new Rectangle(0.0f, 0.0f, 40.0f, 40.0f);
                    white.setFill(Color.WHITE);
                    grid.add(white, i,j);
                    colorWhite=!colorWhite;
                }
                else{
                    Rectangle black= new Rectangle(0.0f, 0.0f, 40.0f, 40.0f);
                    grid.add(black,i,j);
                    colorWhite=!colorWhite;
                }
            }
        }
        Scene scene= new Scene(grid);
        stage.setTitle("Chess Board");
        stage.setScene(scene);
        stage.show();
    }

}

