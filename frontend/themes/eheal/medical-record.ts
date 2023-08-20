import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';

@customElement('medical-record')
export class MedicalRecord extends LitElement {
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
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-text-field label="Disease Name" type="text" id="diseaseName" style="align-self: center; padding: var(--lumo-space-m);"></vaadin-text-field>
  <vaadin-text-field label="Occurence Year" type="int" id="occurenceYear" style="align-self: center; padding: var(--lumo-space-m);" required prevent-invalid-input invalid></vaadin-text-field>
  <vaadin-text-field label="Occurence Month" type="int" style="align-self: center; padding: var(--lumo-space-m);" required prevent-invalid-input id="occurenceMonth"></vaadin-text-field>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
