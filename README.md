# Camera-Modeling

A graphic project implemented in Java, modelling a camera and constructing a graphic
scene using graphic libraries, using the principle of refactoring at every stage and writing tests in JUnit.

## Project description:
The project contains a camera defined from a three-dimensional point - the camera center, And 3 vectors defining the different directions.
The camera has a "ray" that is sent to the object and calculates the points of intersection with it.

Then, I added to the project a class called "Scene" that describes the scene. The fields in this class will be:

  * Name of the scene.
  * Background color.
  *List of elements describing the scene.
  *Camera.
  *Camera distance from the screen.
