/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.komponen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 *
 * @author Ai
 */
public class PanelImpl extends JPanel implements PanelDao {
    private static final long serialVersionUID = 1L;
    private Icon backgroundImage;
    private int backgroundImageType;
    private Paint backgroundPaint;
    private boolean opaqueGradient;
    private boolean opaqueImage;
    private Image gambar;
    
    public PanelImpl(){
        throw new RuntimeException("Compiled Code");
    }
    public Icon getBackgroundImage(){
        throw new RuntimeException("Compiled Code");     
    }
    public int getBackgroundImageType(){
        throw new RuntimeException("Compiled Code");
    }
    public Paint getBacgroundPaint(){
        throw new RuntimeException("Compiled Code");
    }
    public boolean isOpaqueGradient(){
        throw new RuntimeException("Compiled Code");
    }
    public boolean isOpaqueImage(){
        throw new RuntimeException("Compiled Code");
    }
    protected void paintComponent (Graphics g) {
        throw new RuntimeException("Compiled Code");
    }
    public void setBackgroundImage(int backgroundImage) throws IllegalArgumentException {
        throw new RuntimeException("Compiled Code");
    }
    public void setBackgroundImageType(int backgroundImageType) throws IllegalArgumentException{
        throw new RuntimeException("Compiled Code");
    }
    public void setBackgroundPaint(Paint backgroundPaint){
        throw new RuntimeException("Compiled Code");
    }
    public void setOpaqueGradient(boolean opaqueGradient){
        throw new RuntimeException("Compiled Code");
    }
    public void setOpaqueImage(boolean opaqueImage){
        throw new RuntimeException("Compiled Code");
    }
}


