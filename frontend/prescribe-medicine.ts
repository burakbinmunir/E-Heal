import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/text-area/src/vaadin-text-area.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('prescribe-medicine')
export class PrescribeMedicine extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: flex-start;">
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: center;"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing-xs" id="Dosage" style="align-self: center; justify-content: center; margin-right:16%; margin: var(--lumo-space-xl); margin-right: 16%; align-items: center; padding-left: var(--lumo-space-xl);"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="medicines " style="align-self: center;">
   <vaadin-text-field label="Medicine name" placeholder="Medicine" id="medicineName" type="text"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-vertical-layout id="labTestBox" style="align-self: center; justify-content: space-between; align-items: center;"></vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="spacing" id="ButtonPanel" style="align-self: flex-start; justify-content: flex-start; margin-left:31%; padding: var(--lumo-space-s);"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="CommentBox" style="align-self: center; width: 37%; height: 35%;">
   <vaadin-text-area label="Comment" placeholder="Add Comment" style="width: 100%;" id="doctorComments"></vaadin-text-area>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="SavePrecriptionButton" style="align-self: center; justify-content: flex-start; padding: var(--lumo-space-s);"></vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
