package com.gameshopcorp.gameshopengine;
import android.util.Log;

//import com.gameshopcorp.heroes.characters.rune
import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.cursors.plugins.JmeCursor;
import com.jme3.input.Input;
import com.jme3.input.InputManager;
import com.jme3.input.JoyInput;
import com.jme3.input.Joystick;
import com.jme3.input.KeyInput;
import com.jme3.input.KeyNames;
import com.jme3.input.MouseInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.TouchInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.controls.TouchTrigger;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;

import com.jme3.scene.Spatial;
import com.jme3.texture.Image;
import com.jme3.texture.Texture2D;
import com.jme3.texture.image.ColorSpace;
import com.jme3.util.BufferUtils;

import de.lessvoid.nifty.NiftyEvent;
import de.lessvoid.nifty.input.NiftyMouseInputEvent;
import jme3tools.optimize.GeometryBatchFactory;

import com.jme3.asset.AssetKey;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import de.lessvoid.nifty.Nifty;

/**
 * @author gameshopcorp
 */
public final class MyGame extends SimpleApplication {


    private Nifty nifty;


    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(true);
        //for (int i = 0; i < 2; i++) {
        //Front:0

//    SuperCube superCube = new SuperCube(this, new Vector3f(), getRootNode(), null, new String[]{"front"}){
//            @Override
//            public void make() {
//                super.make();
//                modCurrencyLine("front", (byte) 0, (byte) 0,new Vector3f(-4,0,0));
//
//            }
//        };
//        superCube.make();

       // Rune rune = new Rune(this);
        GeometryBatchFactory.optimize(getRootNode());
        // }
        //Publishing To Google Play Store
        //com.google.android.gms.permission.AD_ID
        //SuperCube superCube = new SuperCube(this, new Vector3f(), getRootNode(), null, new String[]{"all"});
        getViewPort().setBackgroundColor(ColorRGBA.Black);

    }

}
