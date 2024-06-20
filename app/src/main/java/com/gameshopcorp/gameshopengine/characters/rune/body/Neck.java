package com.gameshopcorp.heroes.characters.rune.body;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.CurrencyLine;
import com.gameshopcorp.heroes.graphics.CurrencyMesh;
import com.gameshopcorp.heroes.graphics.Layer;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.texture.Image;
import com.jme3.texture.Texture2D;
import com.jme3.texture.image.ColorSpace;
import com.jme3.util.BufferUtils;

import java.nio.ByteBuffer;
import java.util.HashMap;
public class Neck {

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

    public HashMap<String, Vector3f[]> exports;

    public Neck(SimpleApplication app, Vector3f axis, Node node, Vector3f[] imports){

    }
}
