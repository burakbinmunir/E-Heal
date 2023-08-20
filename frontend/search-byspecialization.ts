import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('search-byspecialization')
export class SearchByspecialization extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-horizontal-layout theme="spacing" style="padding: 5%; margin: 0; align-self: center; height: 10%;" id="vaadinHorizontalLayout">
   <vaadin-button style="background-color: white , color:#4591f5" tabindex="0" id="cardiologistSelection">
     Cardiologist 
   </vaadin-button>
   <vaadin-button style="background-color: white , color:#4591f5" tabindex="0" id="dermatologistSelection">
     Dermatologist 
   </vaadin-button>
   <vaadin-button tabindex="0" style="background-color: white , color:#4591f5" id="EyeSpecialistSelection">
     Eye Specialist 
   </vaadin-button>
   <vaadin-button tabindex="0" style="background-color: white , color:#4591f5" id="ChildSpecialistSelection">
     Child specialist 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="padding: 5%; margin: 0; align-self: center; height: 10%;" id="vaadinHorizontalLayout1">
   <vaadin-button tabindex="0" style="background-color: white , color:#4591f5" id="OrthopedicSelection">
     Orthopedic 
   </vaadin-button>
   <vaadin-button tabindex="0" style="background-color: white , color:#4591f5" id="NutritionistSelection">
     Nutritionist 
   </vaadin-button>
   <vaadin-button tabindex="0" style="background-color: white , color:#4591f5" id="ENTSelection">
     ENT Specialist 
   </vaadin-button>
   <vaadin-button tabindex="0" style="background-color: white , color:#4591f5" id="DiabetesSpecialistSelection">
     Diabetes Specialist 
   </vaadin-button>
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
