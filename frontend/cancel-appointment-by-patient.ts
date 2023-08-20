import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';

@customElement('cancel-appointment-by-patient')
export class CancelAppointmentByPatient extends LitElement {
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
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; justify-content: flex-end; flex-direction: row-reverse;" theme="spacing">
 <vaadin-vertical-layout theme="spacing-l" id="form" style="align-self: center; align-items: flex-start; margin-right:2%;">
  <vaadin-horizontal-layout theme="spacing" id="StatusBadge" style="align-self: flex-start; justify-content: flex-start;"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-text-field label="Name" placeholder="Placeholder" id="name" type="text" readonly></vaadin-text-field>
   <vaadin-text-field label="Specialization" placeholder="Placeholder" id="expertise" type="text" readonly></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-text-field label="Phone Number" placeholder="Placeholder" type="text" id="contact" readonly></vaadin-text-field>
   <vaadin-text-field label="Gender" placeholder="Placeholder" type="text" id="gender" readonly></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-text-field label="Email" placeholder="Placeholder" type="text" id="email" readonly></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-text-field label="Appointment Date" placeholder="Placeholder" type="text" id="AppointmentDate" readonly></vaadin-text-field>
   <vaadin-text-field label="Timing" placeholder="Placeholder" id="timing" type="text" readonly></vaadin-text-field>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing" id="sideImage" style="margin-left:8%;"></vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
