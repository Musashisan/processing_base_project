package com.musashisan.processing.base;

import processing.core.PApplet;

public class Application extends PApplet {

    float xmag, ymag = 0.0f;
    float newXmag, newYmag = 0.0f;

    public static void main(String[] args) {
        PApplet.main("com.musashisan.processing.base.Application");
    }

    @Override
    public void settings() {
        this.size(640, 360, P3D);
    }

    @Override
    public void setup() {
        noStroke();
        colorMode(RGB, 1);
    }

    @Override
    public void draw() {
        background(0.5F);

        pushMatrix();
        translate(width / 2, height / 2, -30);

        newXmag = mouseX / (float) width * TWO_PI;
        newYmag = mouseY / (float) height * TWO_PI;

        float diff = xmag - newXmag;
        if (abs(diff) > 0.01) {
            xmag -= diff / 4.0;
        }

        diff = ymag - newYmag;
        if (abs(diff) > 0.01) {
            ymag -= diff / 4.0;
        }

        rotateX(-ymag);
        rotateY(-xmag);

        scale(90);
        beginShape(QUADS);

        fill(0, 1, 1);
        vertex(-1, 1, 1);
        fill(1, 1, 1);
        vertex(1, 1, 1);
        fill(1, 0, 1);
        vertex(1, -1, 1);
        fill(0, 0, 1);
        vertex(-1, -1, 1);

        fill(1, 1, 1);
        vertex(1, 1, 1);
        fill(1, 1, 0);
        vertex(1, 1, -1);
        fill(1, 0, 0);
        vertex(1, -1, -1);
        fill(1, 0, 1);
        vertex(1, -1, 1);

        fill(1, 1, 0);
        vertex(1, 1, -1);
        fill(0, 1, 0);
        vertex(-1, 1, -1);
        fill(0, 0, 0);
        vertex(-1, -1, -1);
        fill(1, 0, 0);
        vertex(1, -1, -1);

        fill(0, 1, 0);
        vertex(-1, 1, -1);
        fill(0, 1, 1);
        vertex(-1, 1, 1);
        fill(0, 0, 1);
        vertex(-1, -1, 1);
        fill(0, 0, 0);
        vertex(-1, -1, -1);

        fill(0, 1, 0);
        vertex(-1, 1, -1);
        fill(1, 1, 0);
        vertex(1, 1, -1);
        fill(1, 1, 1);
        vertex(1, 1, 1);
        fill(0, 1, 1);
        vertex(-1, 1, 1);

        fill(0, 0, 0);
        vertex(-1, -1, -1);
        fill(1, 0, 0);
        vertex(1, -1, -1);
        fill(1, 0, 1);
        vertex(1, -1, 1);
        fill(0, 0, 1);
        vertex(-1, -1, 1);

        endShape();

        popMatrix();
    }
}
