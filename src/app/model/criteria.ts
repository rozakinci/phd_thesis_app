import {Weight} from "./weights";

export class Criteria {
  name: string;
  checked: boolean;
  cost: boolean;
  weight: Weight;

  constructor(name: string, cost: boolean, weight: Weight) {
    this.name = name;
    this.cost = cost;
    this.weight = weight;
    this.checked = true;
  }
}
