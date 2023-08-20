import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/accordion/src/vaadin-accordion-panel.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/password-field/src/vaadin-password-field.js';

@customElement('hsp-signup')
export class HspSignup extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: center; align-items: center;">
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <label style="align-self: center; padding: var(--lumo-space-m);">Basic Details </label>
  <vaadin-accordion-panel style="align-self: center;" tabindex="0" opened>
   <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Name" id="hspName" type="text"></vaadin-text-field>
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Address" id="hspAddress" type="text"></vaadin-text-field>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
  <label style="align-self: center; padding: var(--lumo-space-m);">Contact Details </label>
  <vaadin-accordion-panel style="align-self: center;" tabindex="0">
   <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Phone Number" id="hspPhoneNumber" type="text"></vaadin-text-field>
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Email" id="hspEmail" type="text"></vaadin-text-field>
   </vaadin-horizontal-layout>
  </vaadin-accordion-panel>
  <label style="align-self: center; padding: var(--lumo-space-m);">Authentication Details</label>
  <vaadin-accordion-panel style="align-self: center;" tabindex="0" id="signupButton">
   <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
    <vaadin-text-field error-message="Please enter a value" required invalid="" label="Registration Number" id="hspRegistrationNumber" type="text"></vaadin-text-field>
    <vaadin-password-field label="Password" placeholder="Enter password" id="hspPassword" type="password" required></vaadin-password-field>
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
