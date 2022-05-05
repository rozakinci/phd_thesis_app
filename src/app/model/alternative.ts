export class Alternative {
  // id: string;
  name: string;
  score: number;
  // causality: Fuzzy;
  // uncertainty: Fuzzy;
  // missingData: Fuzzy;
  // outlier: Fuzzy;
  // interpretability: Fuzzy;
  // complexity: Fuzzy;
  // accuracy: Fuzzy;
  // maintainability: Fuzzy;
  // speed: Fuzzy;

  constructor(name: string, score: number) {
    this.name = name;
    this.score = score;
  }
}
