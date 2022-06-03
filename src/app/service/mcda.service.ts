import {Injectable} from '@angular/core';
import {Alternative} from "../model/alternative";

@Injectable({
  providedIn: 'root'
})
export class McdaService {


  public possibleAlternatives: string[] = [];
  public possibleAlternativeList: Alternative[] = [];


  constructor() {

  }

}
