package org.mycholan.rapidjs.model;

/**
 * Saravana Kumar K
 * 
 * @purpose Model class for user access information
 * @param id
 *             access ID
 * @param userid
 *             id of user
 * @param windowid
 *             id of window
 */
public class Rapid_AccessModel {
     private int id;
     private int userid;
     private int windowid;

     public Rapid_AccessModel(int id, int userid, int windowid) {
          super();
          this.id = id;
          this.userid = userid;
          this.windowid = windowid;
     }

     public Rapid_AccessModel() {

     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getUserid() {
          return userid;
     }

     public void setUserid(int userid) {
          this.userid = userid;
     }

     public int getWindowid() {
          return windowid;
     }

     public void setWindowid(int windowid) {
          this.windowid = windowid;
     }
}
