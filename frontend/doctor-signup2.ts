import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/time-picker/src/vaadin-time-picker.js';

@customElement('doctor-signup2')
export class DoctorSignup2 extends LitElement {
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
  <label style="align-self: center;">Medical Centres</label>
  <vaadin-accordion-panel style="padding: var(--lumo-space-m); align-self: center;" tabindex="0" opened>
   <vaadin-horizontal-layout theme="spacing" id="medicalCenterLayout">
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Name" type="text" id="medicalCentreName"></vaadin-text-field>
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Address" type="text" id="medicalCentreAdress"></vaadin-text-field>
    <vaadin-checkbox-group style="padding: var(--lumo-space-m);" id="vaadinCheckboxGroup"></vaadin-checkbox-group>
   </vaadin-horizontal-layout>
   <vaadin-vertical-layout style="justify-content: flex-start; align-items: center;">
    <vaadin-time-picker id="startTime" label="Start Time" required invalid placeholder="Start Time"></vaadin-time-picker>
    <vaadin-time-picker id="endTime" label="End Time" required prevent-invalid-input placeholder="End Time"></vaadin-time-picker>
   </vaadin-vertical-layout>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-button theme="icon" aria-label="Add new" id="addMoreButton" tabindex="0">
     <iron-icon icon="lumo:plus"></iron-icon>
    </vaadin-button>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
  <label style="align-self: center;">Degree Details </label>
  <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
   <vaadin-text-field error-message="Please enter a value" required invalid="" label="Degree Name" id="degreeName" type="text" name="Name"></vaadin-text-field>
   <vaadin-text-field error-message="Please enter a value" required invalid="" label="Completion Year" id="completionYear" type="text"></vaadin-text-field>
   <vaadin-text-field label="Institute" id="institute" type="int"></vaadin-text-field>
   <vaadin-button theme="icon" aria-label="Add new" id="addMoreDegrees" tabindex="0">
    <iron-icon icon="lumo:plus"></iron-icon>
   </vaadin-button>
   <vaadin-text-field label="Registration Number" type="text" required id="resgistrationNumber"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-button id="signupButton" style="align-self: center; padding: var(--lumo-space-m);" tabindex="0">
    Signup 
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
