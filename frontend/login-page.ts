import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/split-layout/src/vaadin-split-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/password-field/src/vaadin-password-field.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('login-page')
export class LoginPage extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; background-image : url(&quot;C:\Users\Mr  Rabbani\Downloads\eheal_webApp\eheal\Hos.jpg&quot;); align-items: center;" id="vaadinVerticalLayout">
 <vaadin-split-layout style="align-self: center; flex-grow: 1;">
  <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; align-items: center; justify-content: center;">
   <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: center; background-color:black">
    <img>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" id="welcome" style="align-self: center;">
    <label id="Welcome To Eheal" style=" font-size: 50px; font-family: 'Brush Script MT';  color: #4591f5">Welcome To Eheal</label>
   </vaadin-horizontal-layout>
   <vaadin-text-field label="Username" id="username" style="align-self: center; padding: var(--lumo-space-m);" type="text" required></vaadin-text-field>
   <vaadin-password-field label="Password" placeholder="Enter password" id="password" style="align-self: center;" type="password" required></vaadin-password-field>
   <vaadin-horizontal-layout theme="spacing" id="forgetPasswordLabel" style="align-self: center;">
    <label id="label" style="align-self: center; padding: var(--lumo-space-xs); margin: var(--lumo-space-s);" text="Forgot Password?">Forgot Paswword? </label>
   </vaadin-horizontal-layout>
   <vaadin-button id="loginButton" style="align-self: center;" tabindex="0">
     Login 
   </vaadin-button>
   <vaadin-horizontal-layout theme="spacing" id="signupLabel" style="align-self: center; padding: var(--lumo-space-s);">
    <label id="label1">Signup? </label>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" slot="secondary" id="hell" style="align-self: center; align-items: center; justify-content: center;"></vaadin-vertical-layout>
 </vaadin-split-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
