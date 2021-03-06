package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.Phase;
import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/** Class of implementing the intersection box, it has no events asociated, this box is the secret key to find
 * the possible ways on the table, it stores inside a phase instance and an exit point.
 *
 */

public class IntersectionBox extends Box {

    //  //  //  //  //  //  //  //  //  //              ATRIBUTES                //  //  //  //  //  //  //  //  //  //

    public Phase phase;

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /*
     * Setters and getters of the class.
     */
    public MotherList<Box> getList() {
        return this.phase.phaseList;
    }

    @Override
    public Phase getPhase() {
        return this.phase;
    }

    /**
     * Constructor 1 of the class: for creating an instantiation of the class whit it's respective ID and phase.
     * @param phase
     * @param id
     */

    /**
     * Constructor 2 of the class: For just instantiating the class.
     */
    public IntersectionBox() {
    }

    /**
     * Method for drawing the box on the canvas.
     *
     * @param x      postion of the up left corner on x axis
     * @param y      postion of the up left corner on y axis
     * @param canvas canvas for drawing the boxes
     */
    public void draw(int x, int y, Canvas canvas) {
        super.draw(x, y, canvas);
        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.valueOf("#efefef"));
        gc.setStroke(Color.BLACK);

        //Draw the rectangle
        //gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);


        if (this.hasStar) {

            Image star = new Image("Proyecto1/DatosParty/GUI/Resources/images/star.png");
            gc.drawImage(star, x, y);
        }
        if (this.isHilighted) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(5);
            gc.strokeRect(x, y, this.height, this.width);

            gc.setLineWidth(1);
            gc.strokeText(new StringBuilder().append(this.excelId).toString(), x + 6, y + (this.width) / 2 + 2);
            this.isHilighted = false;
        }
    }

    @Override
    public void iteract(Player player) throws Exception {
        super.iteract(player);
    }


    public IntersectionBox(Phase phase, int id) {
        this.phase = phase;
        this.isIntersection = true;
        Box.id = id;
        this.tag = "white";
    }

    @Override
    public String getMessage(Player player) {
        return " moves to an empty box.";
    }


    /**
     * Method for printing the box in the run panel in order to check the correct behavior of the table.
     *
     * @return the color of the box.
     */
    @Override
    public String toString() {
        return "IntersectionBox{" +
                "excelId=" + excelId +

                '}';
    }

}
