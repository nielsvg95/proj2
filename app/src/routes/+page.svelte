<script>
  import { onMount } from 'svelte';
  import { writable } from 'svelte/store';

  let naam = "";
  let responses = [];

  // Language store
  const language = writable("English");

  function hoi() {
    fetch(`http://localhost:8090/greet?naam=${naam}&language=${$language}`, {
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then(data => {
        responses = [...responses, data.message];
      });
  }

  const onKeyPress = e => {
    if (e.charCode === 13) hoi();
  }

  onMount(() => {
    hoi(); // initial request to populate responses
  })

  function toggleLanguage() {
    language.update(currentLang => (currentLang === "English" ? "Dutch" : "English"));
    hoi(); // make a new request with the updated language
  }
</script>

<style>
  h1 {
    color: rgb(255, 201, 135);
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size: 2em;
    margin-bottom: .5em;
  }

  p {
    color: cornflowerblue;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size: 1em;
    white-space: pre-line;
  }

  input {
    position: fixed;
    bottom: 10px;
    height: 30px;
    width: 80%;
    right: 10px;
    color: gray;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size: 1em;
  }

  .language-button {
    position: fixed;
    top: 10px;
    right: 10px;
    padding: 5px 10px;
    background-color: #f2f2f2;
    border-radius: 4px;
    cursor: pointer;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  }
</style>

<main>
  <h1>ChatBot</h1>
  <div class="language-button" on:click={toggleLanguage}>
    {#if $language === "English"}
      Switch to Dutch
    {:else}
      Schakel naar Engels
    {/if}
  </div>
  <input type="text" bind:value={naam} on:keypress={onKeyPress} />
  {#if responses.length > 0}
    {#each responses as response}
      <p>{response}</p>
    {/each}
  {/if}
</main>
