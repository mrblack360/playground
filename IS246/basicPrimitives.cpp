// Created By Maswi, MR (2018-04-07595) as an assignment given 25th November 2019

#include <GL/glut.h>
#include <iostream>
#include <string>
using namespace std;

void displayPolygon(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glBegin(GL_POLYGON);
    glVertex3f(0.5, 0.0, 0.0);
    glVertex3f(-0.3, 0.5, 0.0);
    glVertex3f(0.3, 0.5, 0.0);
    glVertex3f(-0.3, -0.2, 0.5);
    glEnd();
    glFlush();
}
void displayLine(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glBegin(GL_LINES);
    glVertex2f(-0.90, -0.90);
    glVertex2f(.95, .95);
    glEnd();
    glFlush();
}

void displayDots(void)
{
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();

    glColor3f(1.0, 1.0, 1.0);

    glPointSize(5.0f);
    glBegin(GL_POINTS);
    glVertex2d(-0.8, 0.0);
    glVertex2d(0.0, 0.8);
    glVertex2d(0.8, 0.0);
    glVertex2d(0.0, -0.8);
    glVertex2d(0.0, 0.0);
    glEnd();

    glFlush();
}

int main(int argc, char **argv)
{
    int choice;
    cout << "DoneBy: Maswi, MR (2018-04-07595)\n";
    cout << "\nChoose the type of primitive you want to view:\n1. Dots\n2. Line\n3. Polygon\n";
    cin >> choice;
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE);
    glutInitWindowSize(400, 300);
    glutInitWindowPosition(100, 350);
    if (choice == 3)
    {
        glutCreateWindow("Maswi's Polygon");
        glutDisplayFunc(displayPolygon);
    }
    else if (choice == 2)
    {
        glutCreateWindow("Maswi's Line Primitive");
        glutDisplayFunc(displayLine);
    }
    else if (choice == 1)
    {
        glutCreateWindow("Maswi's Dots Primitive");
        glutDisplayFunc(displayDots);
    }
    else
        cout << "Incorrect Choice! \n\nByeeeeeeeeeeeeeeeeeeeeeee!\n";
    glutMainLoop();
    return 0;
}
