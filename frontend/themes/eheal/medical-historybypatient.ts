import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './medical-record';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('medical-historybypatient')
export class MedicalHistorybypatient extends LitElement {
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
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-horizontal-layout theme="spacing" id="medicalHistoryImage"></vaadin-horizontal-layout>
  <medical-record id="medicalRecord" style="align-self: center;"></medical-record>
  <label style="align-self: center;">What is your current status of disease?</label>
  <vaadin-vertical-layout theme="spacing" id="statusRadioBoxLayout" style="align-self: center; padding: var(--lumo-space-m);"></vaadin-vertical-layout>
  <vaadin-button id="vaadinButton" style="align-self: center; padding: var(--lumo-space-l);" tabindex="0">
    Done 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
