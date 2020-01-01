// Created By Maswi, MR (2018-04-07595) on December 22, 2019

#include <GL/glut.h>

void drawTriangles()
{
    glBegin(GL_TRIANGLES);
    glColor3f(1.0, 0.0, 0.0);
    glVertex2i(0, 0);
    glVertex2i(-2, 5);
    glVertex2i(2, 5);
    glEnd();

    glBegin(GL_TRIANGLES);
    glColor3f(1.0, 0.0, 0.0);
    glVertex2i(0, 0);
    glVertex2i(5, 2);
    glVertex2i(5, -2);
    glEnd();

    glBegin(GL_TRIANGLES);
    glColor3f(1.0, 0.0, 0.0);
    glVertex2i(0, 0);
    glVertex2i(-2, -5);
    glVertex2i(2, -5);
    glEnd();

    glBegin(GL_TRIANGLES);
    glColor3f(1.0, 0.0, 0.0);
    glVertex2i(0, 0);
    glVertex2i(-5, 2);
    glVertex2i(-5, -2);
    glEnd();
}

void drawDots()
{
    glBegin(GL_POLYGON);
    glPointSize(6.0f);
    glColor3f(0.0, 1.0, 0.0);
    glVertex2i(-1, 0);
    glVertex2i(1, 0);
    glVertex2i(5, -5);
    glVertex2i(-1, -5);
    glVertex2i(-1, 0);
    glEnd();
}

void myDisplay()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
    drawTriangles();
    drawDots();
    glutSwapBuffers();
}
int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(500, 300);
    glutInitWindowPosition(100, 350);
    glutCreateWindow("Maswi's Primitives");
    glutDisplayFunc(myDisplay);
    glutMainLoop();
    return 0;
}
