export enum EnumSize {
  SMALL,
  MEDIUM,
  LARGE
}

export class Dataset {
  // id: string;
  name: string;
  size: EnumSize;
  auc: number;


  constructor(name: string, size: EnumSize, auc: number) {
    this.name = name;
    this.size = size;
    this.auc = auc;
  }
}
