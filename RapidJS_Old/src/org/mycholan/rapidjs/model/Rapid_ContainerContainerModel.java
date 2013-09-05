package org.mycholan.rapidjs.model;

import java.util.ArrayList;

public class Rapid_ContainerContainerModel {
     private int type;
     private int count;
     private ArrayList<Rapid_ContainerModel> containers;

     public Rapid_ContainerContainerModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public int getType() {
          return type;
     }

     public void setType(int type) {
          this.type = type;
     }

     public int getCount() {
          return count;
     }

     public void setCount(int count) {
          this.count = count;
     }

     public ArrayList<Rapid_ContainerModel> getContainers() {
          return containers;
     }

     public void setContainers(ArrayList<Rapid_ContainerModel> containers) {
          this.containers = containers;
     }
}