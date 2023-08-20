import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('display-patientoptions')
export class DisplayPatientoptions extends LitElement {
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
  <vaadin-vertical-layout theme="spacing" id="home"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-vertical-layout theme="spacing" id="iconLayout" style="align-self: flex-end;"></vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-vertical-layout theme="spacing" id="bookAppointmentLayout" style="margin: var(--lumo-space-m);"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="viewAppointmentLayout" style="margin: var(--lumo-space-m); align-self: flex-start;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="healthRecordLayout" style="margin: var(--lumo-space-m);"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-vertical-layout theme="spacing" id="orderMedicinesOnline"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="firstAid"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
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
