export type IDecisionTree = Array<IIndexedTreeNode>;

export interface IIndexedTreeNode {
  node: TreeNode;
  index: number;
}

export class TreeNode {
  public readonly id: nodeId;
  public readonly description: string;
  public decision: boolean | null;
  public readonly yesId: nodeId | null;
  public readonly noId: nodeId | null;

  constructor(
    id: nodeId,
    description: string,
    yesId: nodeId | null,
    noId: nodeId | null
  ) {
    this.id = id;
    this.description = description;
    this.decision = null; // <-- must be null on creation. wait for decision from user.
    this.yesId = yesId;
    this.noId = noId;
  }
}

/**
 * Possible values for a node id.
 */
export type nodeId =
  | 'data'
  | 'humanJudgementAndDataBoth'
  | 'humanJudgement'
  | 'classification'
  | 'prediction'
  | 'sorry'
  | 'sizeForClassificationLarge'
  | 'sizeForClassificationMedium'
  | 'sizeForClassificationSmall'
  | 'smallClassification'
  | 'mediumClassification'
  | 'largeClassification'
  | 'bbnfis'
  | 'bbn'
  | 'sizeForPredictionLarge'
  | 'sizeForPredictionMedium'
  | 'sizeForPredictionSmall'
  | 'smallPrediction'
  | 'mediumPrediction'
  | 'largePrediction'
  | 'humanJudgementWithoutData';
/**
 * Dictionary of nodes by their id.
 */
export const nodeList = {
  data: new TreeNode(
    'data',
    'Do you want your method be dependent only on data?',
    'classification',
    'humanJudgementAndDataBoth'
  ),
  classification: new TreeNode(
    'classification',
    'Do you want to perform classification?',
    'sizeForClassificationLarge',
    'prediction'
  ),
  humanJudgementAndDataBoth: new TreeNode(
    'humanJudgementAndDataBoth',
    'Do you want to construct a model using both human judgement and data?',
    'bbn',
    'humanJudgement'
  ),
  humanJudgement: new TreeNode(
    'humanJudgement',
    'Do you want to construct a model based on only human judgement?',
    'bbnfis',
    'sorry'
  ),
  sizeForClassificationLarge: new TreeNode(
    'sizeForClassificationLarge',
    'Do you have a large sized dataset? (Sample Size > 1000)',
    'largeClassification',
    'sizeForClassificationMedium'
  ),
  sizeForClassificationMedium: new TreeNode(
    'sizeForClassificationMedium',
    'Do you have a medium sized dataset? (500 < Sample Size < 1000)',
    'mediumClassification',
    'sizeForClassificationSmall'
  ),
  sizeForClassificationSmall: new TreeNode(
    'sizeForClassificationSmall',
    'Do you have a small sized dataset? (100 < Sample Size < 500)',
    'smallClassification',
    'humanJudgementWithoutData'
  ),
  prediction: new TreeNode(
    'prediction',
    'Do you want to make a numeric prediction?',
    'sizeForPredictionLarge',
    'sorry'
  ),
  sizeForPredictionLarge: new TreeNode(
    'sizeForPredictionLarge',
    'Do you have a large sized dataset? (Sample Size > 1000)',
    'largePrediction',
    'sizeForPredictionMedium'
  ),
  sizeForPredictionMedium: new TreeNode(
    'sizeForPredictionMedium',
    'Do you have a medium sized dataset? (500 < Sample Size < 1000)',
    'mediumPrediction',
    'sizeForPredictionSmall'
  ),
  sizeForPredictionSmall: new TreeNode(
    'sizeForPredictionSmall',
    'Do you have a small sized dataset? (100 < Sample Size < 500)',
    'smallPrediction',
    'humanJudgementWithoutData'
  ),
  sorry: new TreeNode(
    'sorry',
    'Sorry! No method recommendation for this case :(',
    null,
    null
  ),
  humanJudgementWithoutData: new TreeNode(
    'humanJudgementWithoutData',
    'Looks like your dataset size is not enough for data dependent method usage. Do you want to construct human judgement based model?',
    'bbnfis',
    'sorry'
  ),
  bbnfis: new TreeNode('bbnfis', 'Filtered methods are: BBN & FIS', null, null),
  bbn: new TreeNode('bbn', 'Your only options is using BBN method!', null, null),
  smallClassification: new TreeNode(
    'smallClassification',
    'Filtered methods are: ......',
    null,
    null
  ),
  mediumClassification: new TreeNode(
    'mediumClassification',
    'Filtered methods are: ......',
    null,
    null
  ),
  largeClassification: new TreeNode(
    'largeClassification',
    'Filtered methods are: ......',
    null,
    null
  ),
  smallPrediction: new TreeNode(
    'smallPrediction',
    'Filtered methods are: ......',
    null,
    null
  ),
  mediumPrediction: new TreeNode(
    'mediumPrediction',
    'Filtered methods are: ......',
    null,
    null
  ),
  largePrediction: new TreeNode(
    'largePrediction',
    'Filtered methods are: ......',
    null,
    null
  )
};
