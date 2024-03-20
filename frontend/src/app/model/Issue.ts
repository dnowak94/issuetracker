export class Issue {
    id?:number | null;
    title?:string | null;
    description?:string | null;
    attachments?:File[] | null;
    createdAt?:Date | null = new Date();
    updatedAt?:Date | null = new Date();
}
