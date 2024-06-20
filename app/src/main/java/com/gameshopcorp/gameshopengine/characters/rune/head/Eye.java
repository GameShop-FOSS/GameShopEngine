package com.gameshopcorp.heroes.characters.rune.head;

import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.CurrencyLine;
import com.gameshopcorp.heroes.graphics.CurrencyMesh;
import com.gameshopcorp.heroes.graphics.Layer;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetKey;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.texture.image.ColorSpace;
import com.jme3.util.BufferUtils;

import java.nio.ByteBuffer;
public class Eye {
    CurrencyMesh front;
    CurrencyMesh back;
    CurrencyMesh left;
    CurrencyMesh right;
    CurrencyMesh bottom;
    CurrencyMesh top;
    SimpleApplication app;

    CurrencyLine frontTop;
    CurrencyLine frontBottom;
    CurrencyLine frontRight;
    CurrencyLine frontLeft;

    CurrencyLine backTop;
    CurrencyLine backBottom;
    CurrencyLine backRight;
    CurrencyLine backLeft;

    CurrencyLine topRight;
    CurrencyLine topLeft;
    CurrencyLine bottomLeft;
    CurrencyLine bottomRight;

    public Vector3f axis; //
    public Node node;

    Vector3f[] imports;

    public Eye(SimpleApplication app, Vector3f axis, Node node, Vector3f[] imports){

        this.app = app;
        this.axis = axis.add(new Vector3f(axis));

        this.node = node;

        //this.imports = new Vector3f[4];
        this.imports = imports;
        addEdgeCurrencyLines();
        addFront();
        //addBack();
        //addRight();
        //addLeft();
        //addTop();
        //addBottom();
    }
    public void addEdgeCurrencyLines(){
        Vector3f[] corners = new Vector3f[]{
                //Front:0
                 imports[0], imports[1], imports[2], imports[3],
                //Back:4
                axis.add(new Vector3f(.5f,.5f,-2.5f)), axis.add(new Vector3f(.5f,2.5f,-2.5f)),axis.add(new Vector3f(2.5f,2.5f,-2.5f)), axis.add(new Vector3f(2.5f,.5f,-2.5f))};

//        //Front:0
//        axis.add(new Vector3f(.5f,.5f,-.5f)),axis.add(new Vector3f(.5f,2.5f,-.5f)), axis.add(new Vector3f(2.5f,2.5f,-.5f)),axis.add(new Vector3f(2.5f,.5f,-.5f)),
//                //Back:4
//                axis.add(new Vector3f(.5f,.5f,-2.5f)), axis.add(new Vector3f(.5f,2.5f,-2.5f)),axis.add(new Vector3f(2.5f,2.5f,-2.5f)), axis.add(new Vector3f(2.5f,.5f,-2.5f))};

    //Top Of Head
        frontTop =  new CurrencyLine(new Vector3f[]{ corners[1], FastMath.interpolateLinear(.33f, corners[1], corners[2]).add(0,.25f,0),  FastMath.interpolateLinear(.66f, corners[1], corners[2]).add(0,.25f,0), corners[2]}, (byte) 16);

        //Chin
        frontBottom = new CurrencyLine(new Vector3f[]{corners[0], FastMath.interpolateLinear(.33f, corners[0], corners[3]).add(0,-.125f,0), FastMath.interpolateLinear(.66f, corners[0], corners[3]).add(0,-.125f, 0), corners[3]}, (byte) 16);;

        frontRight = new CurrencyLine(new Vector3f[]{corners[0],FastMath.interpolateLinear(.33f, corners[0], corners[1]) , FastMath.interpolateLinear(.66f, corners[0], corners[1]),corners[1]}, (byte) 16);
        frontLeft = new CurrencyLine(new Vector3f[]{corners[3],FastMath.interpolateLinear(.33f, corners[3], corners[2]) , FastMath.interpolateLinear(.66f, corners[3], corners[2]), corners[2]}, (byte) 16);

        backTop = new CurrencyLine(new Vector3f[]{corners[5], axis.add(new Vector3f(1,3,-3)), axis.add(new Vector3f(2,3,-3)), corners[6] }, (byte) 16);

        //Back Of Neck
        backBottom = new CurrencyLine(new Vector3f[]{corners[4], axis.add(new Vector3f(1,0,-3)), axis.add(new Vector3f(2,0,-3)), corners[7]}, (byte) 16);;

        //Back Of Skull
        backRight = new CurrencyLine(new Vector3f[]{corners[4],axis.add(new Vector3f(0,1,-3)),  axis.add(new Vector3f(0f,2,-3)), corners[5]}, (byte)16);
        backLeft =  new CurrencyLine(new Vector3f[]{corners[7],axis.add(new Vector3f(3,1,-3)), axis.add(new Vector3f(3,2,-3)), corners[6]}, (byte)16);

        topLeft = new CurrencyLine(new Vector3f[]{corners[6],   axis.add(new Vector3f(3,3,-2)), axis.add(new Vector3f(3f,3,-1)),corners[2]}, (byte)16);
        topRight = new CurrencyLine(new Vector3f[]{corners[5],axis.add(new Vector3f(0,3,-2)), axis.add(new Vector3f(0,3,-1)),corners[1]}, (byte)16);

        //Chin Sides
        bottomLeft = new CurrencyLine(new Vector3f[]{corners[7],axis.add(new Vector3f(3,0,-2)),axis.add(new Vector3f(3,0,-1)),corners[3] }, (byte)16) ;
        bottomRight = new CurrencyLine(new Vector3f[]{corners[4],axis.add(new Vector3f(0,0,-2)),axis.add(new Vector3f(0,0,-1)),corners[0] }, (byte)16) ;

    }
    public void addFront(){

      //  Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(1,1,0f)), axis.add(new Vector3f(2,1,0f)), axis.add(new Vector3f(1,2,0f)), axis.add(new Vector3f(2,2,0f)),};

        CurrencyLine cl = frontBottom;
        CurrencyLine cl1 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(frontRight.points[1])), FastMath.interpolateLinear(.33f, frontRight.points[1], frontLeft.points[1]).add(0,0,.2f),  FastMath.interpolateLinear(.66f, frontRight.points[1], frontLeft.points[1]).add(0,0,.2f), axis.add(new Vector3f(frontLeft.points[1]))}, (byte) 16);
        CurrencyLine cl2 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(frontRight.points[2])),  FastMath.interpolateLinear(.33f, frontRight.points[2], frontLeft.points[2]).add(0,0,.2f),  FastMath.interpolateLinear(.66f, frontRight.points[2], frontLeft.points[2]).add(0,0,.2f), axis.add(new Vector3f(frontLeft.points[2]))}, (byte) 16);
        CurrencyLine cl3 = frontTop;
        //Layer layer= new Layer((short) 32, (short) 32);
        //layer.drawCircle((short) 16, (short) 16, (short) 32, ColorRGBA.fromRGBA255(255,255,255,255));

        //DRAW FEACHURES
       // layer.drawCircle((short) 25, (short) 25, (short) 4, ColorRGBA.fromRGBA255(255,225,185,255));

       // layer.drawCircle((short) 8, (short) 16, (short) 8, ColorRGBA.fromRGBA255(65,145,208,255));
        //DRILL COLOR CODE
        // layer.drawCircle((short) 8, (short) 16, (short) 4, ColorRGBA.fromRGBA255(0,0,0,255));

        //layer.drawLine(new Vector2f(16,24), new Vector2f(16, 8), (short) 4, ColorRGBA.fromRGBA255(0,0,0,255));
        //ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        //ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        //Image image = new Image(Image.Format.RGBA8, layer.width, layer.height, data, ColorSpace.Linear);

        Texture2D texture =  (Texture2D) app.getAssetManager().loadTexture("Textures/RuneEye.jpg");
        front = new CurrencyMesh(app, new CurrencyLine[]{cl, cl1, cl2, cl3}, texture, node);

    }

    public void addBack(){

        Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(2,1,-3)), axis.add(new Vector3f(1,1,-3)), axis.add(new Vector3f(2,2,-3)), axis.add(new Vector3f(1,2,-3))};
        CurrencyLine cl = backBottom;
        CurrencyLine cl1 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(backRight.points[1])), mid[0], mid[1] , axis.add(new Vector3f(backLeft.points[1]))}, (byte) 16);
        CurrencyLine cl2 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(backRight.points[2])), mid[2], mid[3] , axis.add(new Vector3f(backLeft.points[2]))}, (byte) 16);
        CurrencyLine cl3 = backTop;

        Layer layer = new Layer((short) 128, (short) 128);
        layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(255,255,255,255));

        //DRILL COLOR CODE
        // layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(0,0,255,255));

        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
        Texture2D texture2D = new Texture2D(image);
        back = new CurrencyMesh(app, new CurrencyLine[]{cl, cl1, cl2, cl3}, texture2D, node);

    }

    public void addRight(){
        Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(0f,1,-2)), axis.add(new Vector3f(0,1, -1)), axis.add(new Vector3f(0,2,-2)), axis.add(new Vector3f(0,2,-1)), };
        CurrencyLine cl = bottomRight;
        CurrencyLine cl1 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(backRight.points[1])), mid[0], mid[1], axis.add(new Vector3f(frontRight.points[1]))}, (byte) 16);
        CurrencyLine cl2 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(backRight.points[2])), mid[2], mid[3], axis.add(new Vector3f(frontRight.points[2]))}, (byte) 16);
        CurrencyLine cl3 = topRight;

        Layer layer= new Layer((short) 128, (short) 128);
        layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(255,255,255,255));

        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
        Texture2D texture2D = new Texture2D(image);
        right = new CurrencyMesh(app, new CurrencyLine[]{cl, cl1, cl2, cl3}, texture2D, node);
    }

    public void addLeft(){

        Vector3f[] mid = new Vector3f[]{ axis.add(new Vector3f(3f,1,-2)), axis.add(new Vector3f(3,1,-1)), axis.add(new Vector3f(3,2,-2)), axis.add(new Vector3f(3,2,-1)) };
        CurrencyLine cl = bottomLeft;
        CurrencyLine cl1 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(backLeft.points[0])), mid[0], mid[1], axis.add(new Vector3f(frontLeft.points[0])),}, (byte) 16);
        CurrencyLine cl2 = new CurrencyLine(new Vector3f[]{axis.add(new Vector3f(backLeft.points[3])), mid[2], mid[3], axis.add(new Vector3f(frontLeft.points[3])),}, (byte) 16);
        CurrencyLine cl3 = topLeft;

        Layer layer= new Layer((short) 128, (short) 128);
        layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(255,255,255,255));

        //layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(0,0,255,255));

        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
        Texture2D texture2D = new Texture2D(image);
        left = new CurrencyMesh(app, new CurrencyLine[]{cl, cl1, cl2, cl3}, texture2D, node);
    }

    public void addTop(){
        Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(1,3,-1)), axis.add(new Vector3f(2,3,-1)),axis.add(new Vector3f(1,3,-2)), axis.add(new Vector3f(2,3,-2)),};
        CurrencyLine cl = frontTop;
        CurrencyLine cl1 = new CurrencyLine(new Vector3f[]{topRight.points[1], mid[0], mid[1],  topLeft.points[1]}, (byte) 16);
        CurrencyLine cl2 = new CurrencyLine(new Vector3f[]{topRight.points[2], mid[2], mid[3],  topLeft.points[2]}, (byte) 16);
        CurrencyLine cl3 = backTop;

        Layer layer= new Layer((short) 128, (short) 128);
        layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(255,255,255,255));

        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
        Texture2D texture2D = new Texture2D(image);
        top = new CurrencyMesh(app, new CurrencyLine[]{cl, cl1, cl2, cl3}, texture2D, node);

    }

    public void addBottom(){
        Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(1,0,-2)), axis.add(new Vector3f(2,0,-2)),axis.add(new Vector3f(1,0,-1)), axis.add(new Vector3f(2,0,-1))};
        CurrencyLine cl = backBottom;
        CurrencyLine cl1 = new CurrencyLine(new Vector3f[]{bottomRight.points[1], mid[0], mid[1],  bottomLeft.points[1]}, (byte) 16);
        CurrencyLine cl2 = new CurrencyLine(new Vector3f[]{bottomRight.points[2], mid[2], mid[3] , bottomLeft.points[2]}, (byte) 16);
        CurrencyLine cl3 = frontBottom;

        Layer layer= new Layer((short) 128, (short) 128);
        layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(255,255,255,255));

        //DRILL COLOR CODE
        // layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(0,0,0,255));

        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
        Texture2D texture2D = new Texture2D(image);
        bottom = new CurrencyMesh(app, new CurrencyLine[]{cl, cl1, cl2, cl3}, texture2D, node);

    }
}
