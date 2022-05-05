import {Component, OnInit} from '@angular/core';
import {Alternative} from "../../model/alternative";
import {AlternativeService} from "../../service/alternative.service";
import {Criteria} from "../../model/criteria";
import {Weight} from "../../model/weights";

@Component({
  selector: 'app-alternative-list',
  templateUrl: './alternative-list.component.html'
})
export class AlternativeListComponent implements OnInit {

  alternatives: Alternative[] = [];
  resultList: Alternative[] = [];
  weights: Weight[] = [];
  criteriaList: Criteria[] = [];
  errorMessage = '';

  constructor(private alternativeService: AlternativeService) {
    this.setWeightsDefaultValues();
    this.setCriteriaList();
    this.setDefaultResultList();
  }

  calculate(): void {

    // function checkSelection(criteria) {
    //   if (!criteria.checked) {
    //     criteria.a = 1;
    //     criteria.b = 1;
    //     criteria.c = 1;
    //   }
    //   return criteria;
    // }

    // let filteredCriteriaList = this.criteriaList.map(checkSelection);
    this.alternativeService.calculate(this.criteriaList, this.resultList).subscribe({
      next: result => this.resultList = result,
      error: err => this.errorMessage = err
    });
  }

  ngOnInit() {
    this.alternativeService.findAll().subscribe(data => {
      this.alternatives = data;
    });
  }

  clearAllWeights() {
    for (const weight of this.weights) {
      weight.a = 1;
      weight.b = 1;
      weight.c = 1;
    }
  }

  setDefaultValues() {
    this.setWeightsDefaultValues();
    this.setCriteriaList();
  }

  clearResults() {
    this.setDefaultResultList();
  }

  deleteAlternative(i: number) {
    this.resultList.splice(i, 1);
  }

  private setCriteriaList() {
    this.criteriaList = [];
    this.criteriaList.length = 0;
    this.criteriaList.push(new Criteria("Causality", false, this.weights[0]));
    this.criteriaList.push(new Criteria("Uncertainty", false, this.weights[1]));
    this.criteriaList.push(new Criteria("Missing Data", false, this.weights[2]));
    this.criteriaList.push(new Criteria("Outlier", false, this.weights[3]));
    this.criteriaList.push(new Criteria("Interpretability", false, this.weights[4]));
    this.criteriaList.push(new Criteria("Complexity", true, this.weights[5])); // is cost
    this.criteriaList.push(new Criteria("Accuracy", false, this.weights[6]));
    this.criteriaList.push(new Criteria("Maintainability", false, this.weights[7]));
    this.criteriaList.push(new Criteria("Speed", false, this.weights[8]));
  }

  private setWeightsDefaultValues() {
    this.weights = [];
    this.weights.length = 0;
    this.weights.push(new Weight(1, 5.75, 9));
    this.weights.push(new Weight(1, 7.5, 9));
    this.weights.push(new Weight(1, 6.25, 9));
    this.weights.push(new Weight(3, 6.5, 9));
    this.weights.push(new Weight(1, 6.75, 9));
    this.weights.push(new Weight(1, 6.25, 9));
    this.weights.push(new Weight(5, 8, 9));
    this.weights.push(new Weight(1, 7, 9));
    this.weights.push(new Weight(1, 5.75, 9));
  }

  private setDefaultResultList() {
    this.resultList = [];
    this.resultList.push(new Alternative("ANN", 0));
    this.resultList.push(new Alternative("BBN", 0));
    this.resultList.push(new Alternative("DT", 0));
    this.resultList.push(new Alternative("FRBC", 0));
    this.resultList.push(new Alternative("LinR", 0));
    this.resultList.push(new Alternative("LogR", 0));
    this.resultList.push(new Alternative("NB", 0));
    this.resultList.push(new Alternative("SVM", 0));
  }
}
