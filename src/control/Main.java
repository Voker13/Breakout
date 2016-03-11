package control;

public class Main {
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.initialize();
    }
    
}

/*
 * MVC-Struktur Umsetztung
 * 
 * 
 * Unser Programm startet mit der Main, in der als einzige Anweisung ein controller instanziert und inizialisiert wird.
 * 
 * Im Controller befinden sich alle wichtigen Variablen, welche alle private sind, 
 * aber �ber getter und setter erreicht werden k�nnen. In dieser Klasse befinden sich unter andrem die Logic Mathode, 
 * die den z.B den richtigen Winkel des Balles berechnet, sowie weitere Hilfsmethoden.
 * 
 * Der Controller instanciiert(Model) beim Start in der Main einen Ball, eine Bar, sowie ein Grid, 
 * welches ein Array aus Bricks ist, und sich je nach Level unterschiedlich f�llen kann via .fill(int). 
 * 
 * Des weiteren wird ein Frame instanciiert(View), welcher ein JFrame extended. 
 * Diese instaciiert wiederum ein Optionpanel, als auch ein Gamepanel.
 * 
 * Den meisten dieser instancen wird beim erstellen der controller �bergeben, 
 * mit dessen Hilfe wiederum �ber beispielsweise -> controller.getBall().(...); <- auf alles andere 
 * zugegriffen werden kann.
 *  
 *  Um das spiel allerdings zum Laufen(in Bewegung) zu bringen, 
 *  muss ein Thread erstellt werden(GameThread). Dies passiert ebenfalls in der Controllerklasse beim inizialisieren().
 *  
 *  Da zum Beispiel der ganzzahlige Wert FPS nur in der Threadklasse gebraucht wird, haben wir uns dazu entschieden,
 *  dem Crontroller ausnahmsweise diesen Wert vorzubehalten und ihn stattdessen in der Threadklasse inizialisieren.
 *  
 *  Der Thread f�hrt sich alle [(1000ms/60fps)-rechenzeit pro durchlauf ] aus.
 *  Dieser hat im Grunde nur die Aufgabe den Frame zu repainten(). Dabei rufen sich automatisch die paintComponent Methoden
 *  in beiden Paneln auf und zeichenen die Objekte (Ball; Bar; Grid) mit den aktuellen Variablen auf, welche durch doLogic und Ball.move() u.a. ver�ndert werden.
 *  Die Methoden werden ebenfalls pro FPS im Thread je nach Spielsituation aufgerufen.
 *  
 *  Wie das funktioniert: Dem Thread wird beim instaciieren ein(das) controller-object �bergeben, welches nat�rlich gespeichert wird. 
 *  Mittels dieses Objektes kann nun z.B. dem Frame gesagt werden, dass dieser neu zeichenen soll(repaint).
 *  Das geht beispielsweise so: (wir befinden uns in der Threadklasse) controller.getFrame().repaint().
 *  Oder z.B beim setzen der Fensterh�he: (wir befinden uns in der Frameklasse) controller.getFrameHeight(); .
 *  Oder soll das �bergangs-gif eingeblendet werden, wenn man ein Level druchgespielt hat: 
 *  also kann man schreiben: controller.getFrame.getGamepanel.doTransition(); 
 *  do transition() k�mmert sich dann um den reibungslosen �bergang und einblendung des neuen grids.
 *  Dabei ist allerdings ist anzumerken, dass hier nun das Gamepanel nicht vom controller genommen wird,
 *  sondern vom Frame geholt wird, wo diese auch instanciiert worden. (dies ist eine weitere einschr�nkung(s. FPS) zum MVC-Model,
 *  was wir aber bewusst gemacht haben, der �bersicht halber.)
 *  
 * 
 * Um der Struktur ausdruck zu verleihen, haben wir die verschieden Klassen zudem noch auf die Ordner: controll, model und view aufgeteilt. 
 * 
 */