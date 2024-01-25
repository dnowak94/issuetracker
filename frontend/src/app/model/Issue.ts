export class Issue {
    private _title: string = "";
    private _id: number = 0;
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get title(): string {
        return this._title;
    }
    public set title(value: string) {
        this._title = value;
    }
    private _description: string = "";
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    private _updatedAt: Date = new Date();
    public get updatedAt(): Date {
        return this._updatedAt;
    }
    public set updatedAt(value: Date) {
        this._updatedAt = value;
    }
    private _createdAt: Date = new Date();
    public get createdAt(): Date {
        return this._createdAt;
    }
    public set createdAt(value: Date) {
        this._createdAt = value;
    }

    public constructor(title:string, description:string) {
        this._id = 0;
        this._title = title;
        this._description = description;
        this._createdAt = new Date();
        this._updatedAt = new Date();
    }
}
