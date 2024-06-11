import { Component, Input } from '@angular/core';
import { AbstractControl, FormControl } from '@angular/forms';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrl: './input.component.css'
})

export class InputComponent {
  @Input() 
  set control(value: AbstractControl<any,any>){
    this._control = value as FormControl;
  }
  get control(){
    return this._control;
  }
  _control!:FormControl;
  @Input() label:string | undefined;
  @Input() inputType: string = 'text';
  @Input() controlType:string = 'input';

  constructor() {}

  showErrors() {
    const {dirty, touched, errors } = this.control!;
    return dirty && touched && errors;
  }

  getControl(control: AbstractControl<any, any>): FormControl {
    return control as FormControl;
  }
}
