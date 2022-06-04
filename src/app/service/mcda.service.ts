import {Injectable} from '@angular/core';
import {Alternative} from "../model/alternative";
import {Dataset} from "../model/dataset";

@Injectable({
  providedIn: 'root'
})
export class McdaService {


  public datasetList: Dataset[] = [];
  public possibleAlternativeList: Alternative[] = [];


  constructor() {

  }

}
