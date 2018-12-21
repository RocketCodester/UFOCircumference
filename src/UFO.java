
import org.lgna.story.resources.aircraft.UFOResource;
import org.lgna.story.*;

public class UFO extends Aircraft {
    public double calculateCircumference(){
        return 3.14 * this.getWidth();
    }
    public UFO() {
        super(UFOResource.UFO);
    }

    public SJoint getFin() {
        return this.getJoint(UFOResource.FIN);
    }

    public SJoint getRightDoor() {
        return this.getJoint(UFOResource.RIGHT_DOOR);
    }

    public SJoint getLeftDoor() {
        return this.getJoint(UFOResource.LEFT_DOOR);
    }
}
