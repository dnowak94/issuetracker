/**
 * Issuetracker - OpenAPI 3.0.3
 * Some useful links: - [The Issuetracker repository](https://github.com/swagger-api/swagger-projectstore) - [The source API definition for the projects service](https://github.com/dnowak94/issuetracker/blob/master/backend/openapi.yaml)
 *
 * OpenAPI spec version: 1.0.11
 * Contact: dnowak94@live.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

export interface Task { 
    id?: number;
    title?: string;
    description?: string;
    /**
     * Tasks Status
     */
    status?: Task.StatusEnum;
    createdAt?: Date;
    updatedAt?: Date;
}
export namespace Task {
    export type StatusEnum = 'todo' | 'work_in_progress' | 'done';
    export const StatusEnum = {
        Todo: 'todo' as StatusEnum,
        WorkInProgress: 'work_in_progress' as StatusEnum,
        Done: 'done' as StatusEnum
    };
}