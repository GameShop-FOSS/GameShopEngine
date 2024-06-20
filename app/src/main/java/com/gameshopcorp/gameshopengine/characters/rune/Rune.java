package com.gameshopcorp.heroes.characters.rune;

import com.gameshopcorp.heroes.characters.rune.head.Eye;
import com.gameshopcorp.heroes.characters.rune.head.Hair;
import com.gameshopcorp.heroes.characters.rune.head.Head;
import com.gameshopcorp.heroes.characters.rune.head.Nose;
import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Objects;

public class Rune {

    public Rune(SimpleApplication app){

        Node headNode = new Node("Head");

        HashMap<String, Vector3f> corners = new HashMap<>();
        corners.put("frontBottomLeft", (new Vector3f(.5f,-1,0)));
        corners.put("frontTopLeft", new Vector3f(.75f, 3,0));
        corners.put("frontTopRight", (new Vector3f(2.25f,3,0)));
        corners.put("frontBottomRight", (new Vector3f(2.5f,-1,0)));
        corners.put("backBottomLeft", (new Vector3f(.75f,1,-3)));
        corners.put("backTopLeft", (new Vector3f(.75f,3,-3)));
        corners.put("backTopRight", (new Vector3f(2.25f,3,-3)));
        corners.put("backBottomRight", (new Vector3f(2.25f,1,-3)));

    Head head = new Head(app, new Vector3f(), headNode, corners, new String[]{"all"});

        Node noseNode = new Node("Nose");
        HashMap<String, Vector3f> corners1 = new HashMap<>();
        corners1.put("frontBottomLeft", (Objects.requireNonNull(head.exports.get("Nose"))[3]).add(0,0, 1));
        corners1.put("frontTopLeft", (Objects.requireNonNull(head.exports.get("Nose"))[2]).add(-.125f,-.25f, .5f));
        corners1.put("frontTopRight", (Objects.requireNonNull(head.exports.get("Nose"))[1]).add(.125f,-.25f,.5f));
        corners1.put("frontBottomRight", (Objects.requireNonNull(head.exports.get("Nose"))[0]).add(0,0,1));
        corners1.put("backBottomLeft", (Objects.requireNonNull(head.exports.get("Nose"))[3]));
        corners1.put("backTopLeft", (Objects.requireNonNull(head.exports.get("Nose"))[2]));
        corners1.put("backTopRight", (Objects.requireNonNull(head.exports.get("Nose"))[1]));
        corners1.put("backBottomRight", (Objects.requireNonNull(head.exports.get("Nose"))[0]));
//        Vector3f[] corners = new Vector3f[]{
//                //Front:0
//                axis.add(new Vector3f(.5f, -0, -.5f)), axis.add(new Vector3f(1.25f, 3f, -2f)), axis.add(new Vector3f(1.75f, 3, -2f)), axis.add(new Vector3f(2.5f, -0, -.5f)),
//                //Back:4
//                axis.add(new Vector3f(0, 0, -3)), axis.add(new Vector3f(1.25f, 3, -3)), axis.add(new Vector3f(1.75f, 3, -3)), axis.add(new Vector3f(3, 0, -3))};

        Nose nose = new Nose(app, new Vector3f(), noseNode, corners1, new String[]{"all"});// CHANGE BEFORE RUNNING

        //noseNode.scale(.25f);
        //noseNode.scale(1,2,1);
        //noseNode.move(new Vector3f(1.1f, 0f,1.25f));
        headNode.attachChild(noseNode);

//        Node hairTopNode = new Node("HairTop");
//        Hair hairTop = new Hair(app, new Vector3f(), hairTopNode);
//       // hairTopNode.scale(.75f,1.5f,.75f);
//        hairTopNode.scale(1.5f);
//        hairTopNode.scale(1.1f, 1.25f,1.1f);
//        hairTopNode.move(-1,5,-1.5f);
//        hairTopNode.rotate(-45,0,0);
//         headNode.attachChild(hairTopNode);
//
//        Node hairBottomLeftNode = new Node("HairBottomLeft");
//        Hair hairBottomLeft = new Hair(app, new Vector3f(), hairBottomLeftNode);
//        // hairTopNode.scale(.75f,1.5f,.75f);
//        hairBottomLeftNode.scale(1.5f);
//        hairBottomLeftNode.scale(1.1f, 1.25f,1.1f);
//        hairBottomLeftNode.move(-1,2,-1.5f);
//        hairBottomLeftNode.rotate(-115,45,0);
//        headNode.attachChild(hairBottomLeftNode);
//
//        Node hairBottomRightNode = new Node("HairBottomRight");
//        Hair hairBottomRight = new Hair(app, new Vector3f(), hairBottomRightNode);
//        // hairTopNode.scale(.75f,1.5f,.75f);
//        hairBottomRightNode.scale(1.5f);
//        hairBottomRightNode.scale(1.1f, 1.25f,1.1f);
//        hairBottomRightNode.move(1,2,-5.5f);
//        hairBottomRightNode.rotate(-115,-45,0);
//        headNode.attachChild(hairBottomRightNode);


        Node eyeLeftNode = new Node("EyeLeft");
        Eye eyeLeft = new Eye(app, new Vector3f(), eyeLeftNode, head.exports.get("EyeLeft"));
//        eyeLeftNode.scale(.25f);
        eyeLeftNode.move(0,0,0.075f);
        headNode.attachChild(eyeLeftNode);

        Node eyeRightNode = new Node("EyeRight");
        Eye eyeRight = new Eye(app, new Vector3f(), eyeRightNode, head.exports.get("EyeRight"));
        //eyeRightNode.scale(.25f);
        eyeRightNode.move(0,0,0.075f);
        headNode.attachChild(eyeRightNode);

        //headNode.rotate(0,90,0);
        Node runeNode = new Node("Rune");
        runeNode.attachChild(headNode);
        app.getRootNode().attachChild(runeNode);
        //SuperCube superCube = new SuperCube(app, new Vector3f(), app.getRootNode());
    }
}
