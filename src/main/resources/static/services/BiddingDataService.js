/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import http from "../http-common";

class TutorialDataService {
  getAll() {
    return http.get("/bidding");
  }

  get(id) {
    return http.get(`/bidding/view/${id}`);
  }

  create(data) {
    return http.post("/bidding/add/", data);
  }

  update(id, data) {
    return http.put(`/bidding/edit/${id}`, data);
  }

  delete(id) {
    return http.delete(`/bidding/delete/${id}`);
  }

  deleteAll() {
    return http.delete(`/bidding/delete/all`);
  }

  findByAlias(alias) {
    return http.get(`/bidding?alias=${alias}`);
  }
}

export default new BiddingDataService();
