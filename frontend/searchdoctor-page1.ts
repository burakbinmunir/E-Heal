import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('searchdoctor-page1')
export class SearchdoctorPage1 extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; margin: var(--lumo-space-s);" id="vaadinVerticalLayout">
 <h1 style="align-self: center; color: #4591f5">Find and book the best doctors</h1>
 <vaadin-vertical-layout theme="spacing" id="searchLayout"></vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing" id="searchSpecilist" style="align-self: center;">
  <label style="align-self: center; flex-grow: 1;">Looking for specialist?</label>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
