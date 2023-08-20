import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/time-picker/src/vaadin-time-picker.js';
import '@vaadin/date-picker/src/vaadin-date-picker.js';
import '@vaadin/text-area/src/vaadin-text-area.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('book-docapp')
export class BookDocapp extends LitElement {
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
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; padding: var(--lumo-space-s);">
  <label style="align-self: center; padding: var(--lumo-space-m); color: #4591f5; font-size: 30px">Book Appointment</label>
  <label style="align-self: center; padding: var(--lumo-space-m);">Pick Date and Time </label>
  <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
   <vaadin-date-picker label="Date" placeholder="Pick a date" id="date"></vaadin-date-picker>
   <vaadin-time-picker id="startTime" label="Start Time" required placeholder="Pick Time"></vaadin-time-picker>
   <vaadin-time-picker id="endTime" label="End Time" required placeholder="Pick Time"></vaadin-time-picker>
  </vaadin-horizontal-layout>
  <vaadin-text-area label="Write a short description about your current condition (100 Words)" placeholder="" id="currentCondition" style="align-self: stretch; padding: var(--lumo-space-l); flex-grow: 1;
" maxlength="100"></vaadin-text-area>
  <vaadin-button id="bookAppointmentButton" style="align-self: center;" tabindex="0">
   Book Appointment 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
