/* 
   10/7/14
   Calculate circumference of UFOs using a function
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.*;

public class Scene extends SScene {

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(Color.PINK);
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(new Color(0.0431, 0.0, 0.0941));
        this.setFogDensity(0.25);
        this.setName("myScene");
        this.ground.setPaint(SGround.SurfaceAppearance.MARS);
        this.ground.setOpacity(1.0);
        this.ground.setName("ground");
        this.ground.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995185, 0.0980144, 6.12323E-17));
        this.camera.setPositionRelativeToVehicle(new Position(9.61E-16, 1.56, -7.85));
        this.ufo1.setPaint(Color.WHITE);
        this.ufo1.setOpacity(1.0);
        this.ufo1.setName("ufo1");
        this.ufo1.setVehicle(this);
        this.ufo1.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.ufo1.setPositionRelativeToVehicle(new Position(5.72, 0.0, 13.3));
        this.ufo1.setSize(new Size(2.92, 1.43, 2.59));
        this.ufo2.setPaint(Color.WHITE);
        this.ufo2.setOpacity(1.0);
        this.ufo2.setName("ufo2");
        this.ufo2.setVehicle(this);
        this.ufo2.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.ufo2.setPositionRelativeToVehicle(new Position(0.952, 0.0, 9.59));
        this.ufo2.setSize(new Size(4.2, 2.06, 3.73));
        this.ufo3.setPaint(Color.WHITE);
        this.ufo3.setOpacity(1.0);
        this.ufo3.setName("ufo3");
        this.ufo3.setVehicle(this);
        this.ufo3.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.ufo3.setPositionRelativeToVehicle(new Position(-6.58, 0.0, 18.2));
        this.ufo3.setSize(new Size(8.02, 3.93, 7.13));
        this.alien.setPaint(Color.WHITE);
        this.alien.setOpacity(1.0);
        this.alien.setName("alien");
        this.alien.setVehicle(this);
        this.alien.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.alien.setPositionRelativeToVehicle(new Position(-0.484, 0.0, -1.99));
        this.alien.setSize(new Size(0.566, 1.44, 0.578));
    }

    private void initializeEventListeners() {
        this.addSceneActivationListener(new SceneActivationListener() {
            @Override
            public void sceneActivated(final SceneActivationEvent e) {
                Scene.this.myFirstMethod();
            }
        });
    }

    @Override
    protected void handleActiveChanged(final Boolean isActive, final Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public void myFirstMethod() {
        alien.say("I am going to calculate the circumference for the UFOs");
        double ufo1Width = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter a width for UFO 1"));
        double ufo2Width = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter a width for UFO 2"));
        double ufo3Width = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter a width for UFO 3"));
        ufo1.setWidth(ufo1Width);
        ufo2.setWidth(ufo2Width);
        ufo3.setWidth(ufo3Width);
        DecimalFormat twoDecimals = new DecimalFormat("0.00");
        alien.say("UFO 1 Circumference: " + 
                twoDecimals.format(ufo1.calculateCircumference()));
        alien.say("UFO 2 Circumference: " + 
                twoDecimals.format(ufo2.calculateCircumference()));
        alien.say("UFO 3 Circumference: " + 
                twoDecimals.format(ufo3.calculateCircumference()));
    }

    public SGround getGround() {
        return this.ground;
    }

    public SCamera getCamera() {
        return this.camera;
    }

    public UFO getUfo1() {
        return this.ufo1;
    }

    public UFO getUfo2() {
        return this.ufo2;
    }

    public UFO getUfo3() {
        return this.ufo3;
    }

    public Alien getAlien() {
        return this.alien;
    }
    private final SGround ground = new SGround();
    private final SCamera camera = new SCamera();
    private final UFO ufo1 = new UFO();
    private final UFO ufo2 = new UFO();
    private final UFO ufo3 = new UFO();
    private final Alien alien = new Alien();
}
