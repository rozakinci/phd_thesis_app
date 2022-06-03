import {Component, OnInit} from "@angular/core";
import {IDecisionTree, nodeList, TreeNode} from "./nodes";
import {Router} from "@angular/router";
import {McdaService} from "../service/mcda.service";

@Component({
  selector: "app-decision-tree-form",
  templateUrl: "./decision-tree-form.component.html",
  styleUrls: ["./decision-tree-form.component.css"]
})
export class DecisionTreeFormComponent implements OnInit {
  public decisionTree: IDecisionTree = [];
  // @ts-ignore
  public currentNode: TreeNode;

  public treeJSONhidden: boolean = true;
  public nodeJSONhidden: boolean = true;

  constructor(private router: Router, private mcdaService: McdaService) {
  }

  ngOnInit() {
    this.reset();
  }

  public reset() {
    // Init base node and tree here.
    this.decisionTree = [];
    this.currentNode = Object.assign({}, nodeList.data);
  }

  public yes() {
    this.currentNode.decision = true;
    this.pushNode();
    // @ts-ignore
    this.currentNode = Object.assign({}, nodeList[this.currentNode.yesId]);
    if (this.isFinal(this.currentNode)) {
      this.pushNode();
    }
  }

  public no() {
    this.currentNode.decision = false;
    this.pushNode();
    // @ts-ignore
    this.currentNode = Object.assign({}, nodeList[this.currentNode.noId]);
    if (this.isFinal(this.currentNode)) {
      this.pushNode();
    }
  }

  public isFinal = (node: TreeNode) => node.yesId == null && node.noId == null;

  private pushNode(): void {
    this.decisionTree.push({
      node: this.currentNode,
      index: this.decisionTree.length
    });
  }

  proceed() {


    let selectedAlts = this.currentNode.resultList;
    this.mcdaService.possibleAlternativeList = [];
    selectedAlts.forEach(value => {
      this.mcdaService.possibleAlternativeList.push(value);

    })
    console.log(selectedAlts);
    this.router.navigate(['/', 'alternatives']);
  }
}
