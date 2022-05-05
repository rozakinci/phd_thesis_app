import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Alternative} from "../model/alternative";
import {Criteria} from "../model/criteria";

@Injectable({
  providedIn: 'root'
})
export class AlternativeService {


  private alternativesUrl: string;
  private resultUrl: string;

  // httpOptions = {
  //   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  // };

  constructor(private http: HttpClient) {
    this.alternativesUrl = 'http://localhost:8080/alternatives';
    this.resultUrl = 'http://localhost:8080/result';
  }

  public findAll(): Observable<Alternative[]> {
    return this.http.get<Alternative[]>(this.alternativesUrl);
  }

  public save(alternative: Alternative) {
    return this.http.post<Alternative>(this.alternativesUrl, alternative);
  }

  public calculate(criteriaList: Criteria[], alternativeList: Alternative[]): Observable<Alternative[]> {
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    let body = JSON.stringify({'criteriaList': criteriaList, 'alternativeList': alternativeList});

    return this.http.post<Alternative[]>(this.resultUrl, body, {headers});
  }
}
