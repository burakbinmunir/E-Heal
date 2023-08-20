import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/accordion/src/vaadin-accordion-panel.js';
import '@vaadin/password-field/src/vaadin-password-field.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/date-picker/src/vaadin-date-picker.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('person-signup')
export class PersonSignup extends LitElement {
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
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; justify-content: center; flex-wrap: wrap; align-items: center; ">
  <label style="margin-left: var(--lumo-space-m);">Personal Details </label>
  <vaadin-accordion-panel id="personalDetails" style="padding: var(--lumo-space-m);" tabindex="0">
   <vaadin-horizontal-layout theme="spacing" id="personalDetailsLayout">
    <vaadin-text-field error-message="Required" required invalid="" label="Firstname" id="firstName" type="text"></vaadin-text-field>
    <vaadin-text-field error-message="Required" required invalid="" label="Lastname" id="lastName" type="text"></vaadin-text-field>
    <vaadin-text-field error-message="Required" required invalid="" label="CNIC" type="text" id="cnic" name="CNIC"></vaadin-text-field>
    <vaadin-date-picker label="Date Of Birth" placeholder="Pick a date" id="dateOfBirth" required></vaadin-date-picker>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
  <label style="margin-left: var(--lumo-space-m);">Contact Details</label>
  <vaadin-accordion-panel id="contactDetails" style="padding: var(--lumo-space-m);" tabindex="0">
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-text-field error-message="Required" required invalid="" label="Email" id="email" type="text"></vaadin-text-field>
    <vaadin-text-field error-message="Required" required invalid="" label="Phone Number" type="text" id="phoneNumber"></vaadin-text-field>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
  <label style="margin-left: var(--lumo-space-s);">Authentication Details</label>
  <vaadin-accordion-panel id="authenticationDetails" style="padding: var(--lumo-space-m);" tabindex="0">
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-text-field error-message="Required" required invalid="" label="Security Question" id="securityQuestion" type="text"></vaadin-text-field>
    <vaadin-text-field error-message="Required" required invalid="" label="Answer To Security Question" type="text" id="answerToSecurityQuestion"></vaadin-text-field>
    <vaadin-text-field error-message="Required" required invalid="" label="Username" type="text" id="userName"></vaadin-text-field>
    <vaadin-password-field label="Password" placeholder="Enter password" value="" id="password" type="password" required></vaadin-password-field>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
