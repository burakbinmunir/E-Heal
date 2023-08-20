import { LitElement, html, css, customElement } from 'lit-element';
import './person-signup';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/accordion/src/vaadin-accordion-panel.js';
import '@vaadin/checkbox-group/src/vaadin-checkbox-group.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

@customElement('doctor-signup')
export class DoctorSignup extends LitElement {
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
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <vaadin-button theme="icon" aria-label="Add new" tabindex="0" id="backButton">
   <iron-icon icon="lumo:arrow-left"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; justify-content: flex-start; align-items: center; padding: var(--lumo-space-s);">
  <person-signup style="padding: var(--lumo-space-s);" id="personSignup"></person-signup>
  <label>Doctrate Details </label>
  <vaadin-accordion-panel style="padding: var(--lumo-space-m);" tabindex="0" id="doctrateDetail">
   <vaadin-horizontal-layout theme="spacing" id="doctrateDetailLayout">
    <vaadin-text-field label="Registration Number" type="text" required id="resgistrationNumber"></vaadin-text-field>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
  <vaadin-button id="nextButton" tabindex="0">
   <iron-icon icon="lumo:arrow-right" slot="suffix"></iron-icon> Next 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-checkbox-group></vaadin-checkbox-group>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
